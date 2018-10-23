// https://searchcode.com/api/result/57825309/

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.optimizer.physical;

import static org.apache.hadoop.hive.ql.plan.ReduceSinkDesc.ReducerTraits.UNIFORM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

import org.apache.calcite.util.Pair;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.*;
import org.apache.hadoop.hive.ql.exec.mr.MapRedTask;
import org.apache.hadoop.hive.ql.exec.persistence.MapJoinKey;
import org.apache.hadoop.hive.ql.exec.spark.SparkTask;
import org.apache.hadoop.hive.ql.exec.tez.TezTask;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinInnerBigOnlyLongOperator;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinInnerBigOnlyMultiKeyOperator;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinInnerBigOnlyStringOperator;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinInnerLongOperator;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinInnerMultiKeyOperator;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinInnerStringOperator;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinLeftSemiLongOperator;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinLeftSemiMultiKeyOperator;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinLeftSemiStringOperator;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinOuterLongOperator;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinOuterMultiKeyOperator;
import org.apache.hadoop.hive.ql.exec.vector.mapjoin.VectorMapJoinOuterStringOperator;
import org.apache.hadoop.hive.ql.exec.vector.reducesink.VectorReduceSinkLongOperator;
import org.apache.hadoop.hive.ql.exec.vector.reducesink.VectorReduceSinkMultiKeyOperator;
import org.apache.hadoop.hive.ql.exec.vector.reducesink.VectorReduceSinkStringOperator;
import org.apache.hadoop.hive.ql.exec.vector.ColumnVector.Type;
import org.apache.hadoop.hive.ql.exec.vector.VectorMapJoinOperator;
import org.apache.hadoop.hive.ql.exec.vector.VectorMapJoinOuterFilteredOperator;
import org.apache.hadoop.hive.ql.exec.vector.VectorSMBMapJoinOperator;
import org.apache.hadoop.hive.ql.exec.vector.VectorizationContext;
import org.apache.hadoop.hive.ql.exec.vector.VectorizationContext.InConstantType;
import org.apache.hadoop.hive.ql.exec.vector.VectorizationContextRegion;
import org.apache.hadoop.hive.ql.exec.vector.expressions.IdentityExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.VectorExpression;
import org.apache.hadoop.hive.ql.exec.vector.expressions.aggregates.VectorAggregateExpression;
import org.apache.hadoop.hive.ql.io.AcidUtils;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatchCtx;
import org.apache.hadoop.hive.ql.lib.DefaultGraphWalker;
import org.apache.hadoop.hive.ql.lib.DefaultRuleDispatcher;
import org.apache.hadoop.hive.ql.lib.Dispatcher;
import org.apache.hadoop.hive.ql.lib.GraphWalker;
import org.apache.hadoop.hive.ql.lib.Node;
import org.apache.hadoop.hive.ql.lib.NodeProcessor;
import org.apache.hadoop.hive.ql.lib.NodeProcessorCtx;
import org.apache.hadoop.hive.ql.lib.PreOrderOnceWalker;
import org.apache.hadoop.hive.ql.lib.PreOrderWalker;
import org.apache.hadoop.hive.ql.lib.Rule;
import org.apache.hadoop.hive.ql.lib.RuleRegExp;
import org.apache.hadoop.hive.ql.lib.TaskGraphWalker;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.metadata.VirtualColumn;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.plan.AbstractOperatorDesc;
import org.apache.hadoop.hive.ql.plan.AggregationDesc;
import org.apache.hadoop.hive.ql.plan.BaseWork;
import org.apache.hadoop.hive.ql.plan.ExprNodeColumnDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeGenericFuncDesc;
import org.apache.hadoop.hive.ql.plan.FileSinkDesc;
import org.apache.hadoop.hive.ql.plan.GroupByDesc;
import org.apache.hadoop.hive.ql.plan.JoinDesc;
import org.apache.hadoop.hive.ql.plan.MapJoinDesc;
import org.apache.hadoop.hive.ql.plan.MapWork;
import org.apache.hadoop.hive.ql.plan.OperatorDesc;
import org.apache.hadoop.hive.ql.plan.VectorGroupByDesc.ProcessingMode;
import org.apache.hadoop.hive.ql.plan.VectorPartitionConversion;
import org.apache.hadoop.hive.ql.plan.PartitionDesc;
import org.apache.hadoop.hive.ql.plan.ReduceSinkDesc;
import org.apache.hadoop.hive.ql.plan.ReduceWork;
import org.apache.hadoop.hive.ql.plan.SMBJoinDesc;
import org.apache.hadoop.hive.ql.plan.SparkHashTableSinkDesc;
import org.apache.hadoop.hive.ql.plan.SparkWork;
import org.apache.hadoop.hive.ql.plan.TableDesc;
import org.apache.hadoop.hive.ql.plan.TableScanDesc;
import org.apache.hadoop.hive.ql.plan.TezWork;
import org.apache.hadoop.hive.ql.plan.VectorGroupByDesc;
import org.apache.hadoop.hive.ql.plan.VectorMapJoinDesc;
import org.apache.hadoop.hive.ql.plan.VectorMapJoinDesc.HashTableImplementationType;
import org.apache.hadoop.hive.ql.plan.VectorMapJoinDesc.HashTableKeyType;
import org.apache.hadoop.hive.ql.plan.VectorMapJoinDesc.HashTableKind;
import org.apache.hadoop.hive.ql.plan.VectorPartitionDesc.VectorDeserializeType;
import org.apache.hadoop.hive.ql.plan.VectorReduceSinkDesc;
import org.apache.hadoop.hive.ql.plan.VectorReduceSinkInfo;
import org.apache.hadoop.hive.ql.plan.VectorPartitionDesc;
import org.apache.hadoop.hive.ql.plan.api.OperatorType;
import org.apache.hadoop.hive.ql.udf.UDFAcos;
import org.apache.hadoop.hive.ql.udf.UDFAsin;
import org.apache.hadoop.hive.ql.udf.UDFAtan;
import org.apache.hadoop.hive.ql.udf.UDFBin;
import org.apache.hadoop.hive.ql.udf.UDFConv;
import org.apache.hadoop.hive.ql.udf.UDFCos;
import org.apache.hadoop.hive.ql.udf.UDFDayOfMonth;
import org.apache.hadoop.hive.ql.udf.UDFDegrees;
import org.apache.hadoop.hive.ql.udf.UDFExp;
import org.apache.hadoop.hive.ql.udf.UDFFromUnixTime;
import org.apache.hadoop.hive.ql.udf.UDFHex;
import org.apache.hadoop.hive.ql.udf.UDFHour;
import org.apache.hadoop.hive.ql.udf.UDFLength;
import org.apache.hadoop.hive.ql.udf.UDFLike;
import org.apache.hadoop.hive.ql.udf.UDFLn;
import org.apache.hadoop.hive.ql.udf.UDFLog;
import org.apache.hadoop.hive.ql.udf.UDFLog10;
import org.apache.hadoop.hive.ql.udf.UDFLog2;
import org.apache.hadoop.hive.ql.udf.UDFMinute;
import org.apache.hadoop.hive.ql.udf.UDFMonth;
import org.apache.hadoop.hive.ql.udf.UDFRadians;
import org.apache.hadoop.hive.ql.udf.UDFRand;
import org.apache.hadoop.hive.ql.udf.UDFRegExpExtract;
import org.apache.hadoop.hive.ql.udf.UDFRegExpReplace;
import org.apache.hadoop.hive.ql.udf.UDFSecond;
import org.apache.hadoop.hive.ql.udf.UDFSign;
import org.apache.hadoop.hive.ql.udf.UDFSin;
import org.apache.hadoop.hive.ql.udf.UDFSqrt;
import org.apache.hadoop.hive.ql.udf.UDFSubstr;
import org.apache.hadoop.hive.ql.udf.UDFTan;
import org.apache.hadoop.hive.ql.udf.UDFToBoolean;
import org.apache.hadoop.hive.ql.udf.UDFToByte;
import org.apache.hadoop.hive.ql.udf.UDFToDouble;
import org.apache.hadoop.hive.ql.udf.UDFToFloat;
import org.apache.hadoop.hive.ql.udf.UDFToInteger;
import org.apache.hadoop.hive.ql.udf.UDFToLong;
import org.apache.hadoop.hive.ql.udf.UDFToShort;
import org.apache.hadoop.hive.ql.udf.UDFToString;
import org.apache.hadoop.hive.ql.udf.UDFWeekOfYear;
import org.apache.hadoop.hive.ql.udf.UDFYear;
import org.apache.hadoop.hive.ql.udf.generic.*;
import org.apache.hadoop.hive.serde.serdeConstants;
import org.apache.hadoop.hive.serde2.ColumnProjectionUtils;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.NullStructSerDe;
import org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe;
import org.apache.hadoop.hive.serde2.lazybinary.LazyBinarySerDe;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector.Category;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector.PrimitiveCategory;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.PrimitiveTypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.StructTypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;
import org.apache.hadoop.mapred.SequenceFileInputFormat;
import org.apache.hadoop.mapred.TextInputFormat;

import com.google.common.base.Preconditions;

public class Vectorizer implements PhysicalPlanResolver {

  protected static transient final Logger LOG = LoggerFactory.getLogger(Vectorizer.class);

  static Pattern supportedDataTypesPattern;

  static {
    StringBuilder patternBuilder = new StringBuilder();
    patternBuilder.append("int");
    patternBuilder.append("|smallint");
    patternBuilder.append("|tinyint");
    patternBuilder.append("|bigint");
    patternBuilder.append("|integer");
    patternBuilder.append("|long");
    patternBuilder.append("|short");
    patternBuilder.append("|timestamp");
    patternBuilder.append("|" + serdeConstants.INTERVAL_YEAR_MONTH_TYPE_NAME);
    patternBuilder.append("|" + serdeConstants.INTERVAL_DAY_TIME_TYPE_NAME);
    patternBuilder.append("|boolean");
    patternBuilder.append("|binary");
    patternBuilder.append("|string");
    patternBuilder.append("|byte");
    patternBuilder.append("|float");
    patternBuilder.append("|double");
    patternBuilder.append("|date");
    patternBuilder.append("|void");

    // Decimal types can be specified with different precision and scales e.g. decimal(10,5),
    // as opposed to other data types which can be represented by constant strings.
    // The regex matches only the "decimal" prefix of the type.
    patternBuilder.append("|decimal.*");

    // CHAR and VARCHAR types can be specified with maximum length.
    patternBuilder.append("|char.*");
    patternBuilder.append("|varchar.*");

    supportedDataTypesPattern = Pattern.compile(patternBuilder.toString());
  }

  List<Task<? extends Serializable>> vectorizableTasks =
      new ArrayList<Task<? extends Serializable>>();
  Set<Class<?>> supportedGenericUDFs = new HashSet<Class<?>>();

  Set<String> supportedAggregationUdfs = new HashSet<String>();

  private HiveConf hiveConf;

  private boolean isSpark;

  boolean useVectorizedInputFileFormat;
  boolean useVectorDeserialize;
  boolean useRowDeserialize;

  boolean isSchemaEvolution;

  public Vectorizer() {

    supportedGenericUDFs.add(GenericUDFOPPlus.class);
    supportedGenericUDFs.add(GenericUDFOPMinus.class);
    supportedGenericUDFs.add(GenericUDFOPMultiply.class);
    supportedGenericUDFs.add(GenericUDFOPDivide.class);
    supportedGenericUDFs.add(GenericUDFOPMod.class);
    supportedGenericUDFs.add(GenericUDFOPNegative.class);
    supportedGenericUDFs.add(GenericUDFOPPositive.class);

    supportedGenericUDFs.add(GenericUDFOPEqualOrLessThan.class);
    supportedGenericUDFs.add(GenericUDFOPEqualOrGreaterThan.class);
    supportedGenericUDFs.add(GenericUDFOPGreaterThan.class);
    supportedGenericUDFs.add(GenericUDFOPLessThan.class);
    supportedGenericUDFs.add(GenericUDFOPNot.class);
    supportedGenericUDFs.add(GenericUDFOPNotEqual.class);
    supportedGenericUDFs.add(GenericUDFOPNotNull.class);
    supportedGenericUDFs.add(GenericUDFOPNull.class);
    supportedGenericUDFs.add(GenericUDFOPOr.class);
    supportedGenericUDFs.add(GenericUDFOPAnd.class);
    supportedGenericUDFs.add(GenericUDFOPEqual.class);
    supportedGenericUDFs.add(UDFLength.class);

    supportedGenericUDFs.add(UDFYear.class);
    supportedGenericUDFs.add(UDFMonth.class);
    supportedGenericUDFs.add(UDFDayOfMonth.class);
    supportedGenericUDFs.add(UDFHour.class);
    supportedGenericUDFs.add(UDFMinute.class);
    supportedGenericUDFs.add(UDFSecond.class);
    supportedGenericUDFs.add(UDFWeekOfYear.class);
    supportedGenericUDFs.add(GenericUDFToUnixTimeStamp.class);
    supportedGenericUDFs.add(UDFFromUnixTime.class);

    supportedGenericUDFs.add(GenericUDFDateAdd.class);
    supportedGenericUDFs.add(GenericUDFDateSub.class);
    supportedGenericUDFs.add(GenericUDFDate.class);
    supportedGenericUDFs.add(GenericUDFDateDiff.class);

    supportedGenericUDFs.add(UDFLike.class);
    supportedGenericUDFs.add(GenericUDFRegExp.class);
    supportedGenericUDFs.add(UDFRegExpExtract.class);
    supportedGenericUDFs.add(UDFRegExpReplace.class);
    supportedGenericUDFs.add(UDFSubstr.class);
    supportedGenericUDFs.add(GenericUDFLTrim.class);
    supportedGenericUDFs.add(GenericUDFRTrim.class);
    supportedGenericUDFs.add(GenericUDFTrim.class);

    supportedGenericUDFs.add(UDFSin.class);
    supportedGenericUDFs.add(UDFCos.class);
    supportedGenericUDFs.add(UDFTan.class);
    supportedGenericUDFs.add(UDFAsin.class);
    supportedGenericUDFs.add(UDFAcos.class);
    supportedGenericUDFs.add(UDFAtan.class);
    supportedGenericUDFs.add(UDFDegrees.class);
    supportedGenericUDFs.add(UDFRadians.class);
    supportedGenericUDFs.add(GenericUDFFloor.class);
    supportedGenericUDFs.add(GenericUDFCeil.class);
    supportedGenericUDFs.add(UDFExp.class);
    supportedGenericUDFs.add(UDFLn.class);
    supportedGenericUDFs.add(UDFLog2.class);
    supportedGenericUDFs.add(UDFLog10.class);
    supportedGenericUDFs.add(UDFLog.class);
    supportedGenericUDFs.add(GenericUDFPower.class);
    supportedGenericUDFs.add(GenericUDFRound.class);
    supportedGenericUDFs.add(GenericUDFBRound.class);
    supportedGenericUDFs.add(GenericUDFPosMod.class);
    supportedGenericUDFs.add(UDFSqrt.class);
    supportedGenericUDFs.add(UDFSign.class);
    supportedGenericUDFs.add(UDFRand.class);
    supportedGenericUDFs.add(UDFBin.class);
    supportedGenericUDFs.add(UDFHex.class);
    supportedGenericUDFs.add(UDFConv.class);

    supportedGenericUDFs.add(GenericUDFLower.class);
    supportedGenericUDFs.add(GenericUDFUpper.class);
    supportedGenericUDFs.add(GenericUDFConcat.class);
    supportedGenericUDFs.add(GenericUDFAbs.class);
    supportedGenericUDFs.add(GenericUDFBetween.class);
    supportedGenericUDFs.add(GenericUDFIn.class);
    supportedGenericUDFs.add(GenericUDFCase.class);
    supportedGenericUDFs.add(GenericUDFWhen.class);
    supportedGenericUDFs.add(GenericUDFCoalesce.class);
    supportedGenericUDFs.add(GenericUDFNvl.class);
    supportedGenericUDFs.add(GenericUDFElt.class);
    supportedGenericUDFs.add(GenericUDFInitCap.class);

    // For type casts
    supportedGenericUDFs.add(UDFToLong.class);
    supportedGenericUDFs.add(UDFToInteger.class);
    supportedGenericUDFs.add(UDFToShort.class);
    supportedGenericUDFs.add(UDFToByte.class);
    supportedGenericUDFs.add(UDFToBoolean.class);
    supportedGenericUDFs.add(UDFToFloat.class);
    supportedGenericUDFs.add(UDFToDouble.class);
    supportedGenericUDFs.add(UDFToString.class);
    supportedGenericUDFs.add(GenericUDFTimestamp.class);
    supportedGenericUDFs.add(GenericUDFToDecimal.class);
    supportedGenericUDFs.add(GenericUDFToDate.class);
    supportedGenericUDFs.add(GenericUDFToChar.class);
    supportedGenericUDFs.add(GenericUDFToVarchar.class);
    supportedGenericUDFs.add(GenericUDFToIntervalYearMonth.class);
    supportedGenericUDFs.add(GenericUDFToIntervalDayTime.class);

    // For conditional expressions
    supportedGenericUDFs.add(GenericUDFIf.class);

    supportedAggregationUdfs.add("min");
    supportedAggregationUdfs.add("max");
    supportedAggregationUdfs.add("count");
    supportedAggregationUdfs.add("sum");
    supportedAggregationUdfs.add("avg");
    supportedAggregationUdfs.add("variance");
    supportedAggregationUdfs.add("var_pop");
    supportedAggregationUdfs.add("var_samp");
    supportedAggregationUdfs.add("std");
    supportedAggregationUdfs.add("stddev");
    supportedAggregationUdfs.add("stddev_pop");
    supportedAggregationUdfs.add("stddev_samp");
  }

  private class VectorTaskColumnInfo {
    List<String> allColumnNames;
    List<TypeInfo> allTypeInfos;
    List<Integer> dataColumnNums;

    int partitionColumnCount;
    boolean useVectorizedInputFileFormat;

    String[] scratchTypeNameArray;

    Set<Operator<? extends OperatorDesc>> nonVectorizedOps;

    TableScanOperator tableScanOperator;

    VectorTaskColumnInfo() {
      partitionColumnCount = 0;
    }

    public void setAllColumnNames(List<String> allColumnNames) {
      this.allColumnNames = allColumnNames;
    }
    public void setAllTypeInfos(List<TypeInfo> allTypeInfos) {
      this.allTypeInfos = allTypeInfos;
    }
    public void setDataColumnNums(List<Integer> dataColumnNums) {
      this.dataColumnNums = dataColumnNums;
    }
    public void setPartitionColumnCount(int partitionColumnCount) {
      this.partitionColumnCount = partitionColumnCount;
    }
    public void setScratchTypeNameArray(String[] scratchTypeNameArray) {
      this.scratchTypeNameArray = scratchTypeNameArray;
    }
    public void setUseVectorizedInputFileFormat(boolean useVectorizedInputFileFormat) {
      this.useVectorizedInputFileFormat = useVectorizedInputFileFormat;
    }
    public void setNonVectorizedOps(Set<Operator<? extends OperatorDesc>> nonVectorizedOps) {
      this.nonVectorizedOps = nonVectorizedOps;
    }
    public void setTableScanOperator(TableScanOperator tableScanOperator) {
      this.tableScanOperator = tableScanOperator;
    }

    public Set<Operator<? extends OperatorDesc>> getNonVectorizedOps() {
      return nonVectorizedOps;
    }

    public void transferToBaseWork(BaseWork baseWork) {

      String[] allColumnNameArray = allColumnNames.toArray(new String[0]);
      TypeInfo[] allTypeInfoArray = allTypeInfos.toArray(new TypeInfo[0]);
      int[] dataColumnNumsArray;
      if (dataColumnNums != null) {
        dataColumnNumsArray = ArrayUtils.toPrimitive(dataColumnNums.toArray(new Integer[0]));
      } else {
        dataColumnNumsArray = null;
      }

      VectorizedRowBatchCtx vectorizedRowBatchCtx =
          new VectorizedRowBatchCtx(
            allColumnNameArray,
            allTypeInfoArray,
            dataColumnNumsArray,
            partitionColumnCount,
            scratchTypeNameArray);
      baseWork.setVectorizedRowBatchCtx(vectorizedRowBatchCtx);

      baseWork.setUseVectorizedInputFileFormat(useVectorizedInputFileFormat);
    }
  }

  class VectorizationDispatcher implements Dispatcher {

    private final PhysicalContext physicalContext;

    public VectorizationDispatcher(PhysicalContext physicalContext) {
      this.physicalContext = physicalContext;
    }

    @Override
    public Object dispatch(Node nd, Stack<Node> stack, Object... nodeOutputs)
        throws SemanticException {
      Task<? extends Serializable> currTask = (Task<? extends Serializable>) nd;
      if (currTask instanceof MapRedTask) {
        convertMapWork(((MapRedTask) currTask).getWork().getMapWork(), false);
      } else if (currTask instanceof TezTask) {
        TezWork work = ((TezTask) currTask).getWork();
        for (BaseWork w: work.getAllWork()) {
          if (w instanceof MapWork) {
            convertMapWork((MapWork) w, true);
          } else if (w instanceof ReduceWork) {
            // We are only vectorizing Reduce under Tez.
            if (HiveConf.getBoolVar(hiveConf,
                        HiveConf.ConfVars.HIVE_VECTORIZATION_REDUCE_ENABLED)) {
              convertReduceWork((ReduceWork) w, true);
            }
          }
        }
      } else if (currTask instanceof SparkTask) {
        SparkWork sparkWork = (SparkWork) currTask.getWork();
        for (BaseWork baseWork : sparkWork.getAllWork()) {
          if (baseWork instanceof MapWork) {
            convertMapWork((MapWork) baseWork, false);
          } else if (baseWork instanceof ReduceWork
              && HiveConf.getBoolVar(hiveConf,
                  HiveConf.ConfVars.HIVE_VECTORIZATION_REDUCE_ENABLED)) {
            convertReduceWork((ReduceWork) baseWork, false);
          }
        }
      }
      return null;
    }

    private void convertMapWork(MapWork mapWork, boolean isTez) throws SemanticException {
      VectorTaskColumnInfo vectorTaskColumnInfo = new VectorTaskColumnInfo();
      boolean ret = validateMapWork(mapWork, vectorTaskColumnInfo, isTez);
      if (ret) {
        vectorizeMapWork(mapWork, vectorTaskColumnInfo, isTez);
      }
    }

    private void addMapWorkRules(Map<Rule, NodeProcessor> opRules, NodeProcessor np) {
      opRules.put(new RuleRegExp("R1", TableScanOperator.getOperatorName() + ".*"
          + FileSinkOperator.getOperatorName()), np);
      opRules.put(new RuleRegExp("R2", TableScanOperator.getOperatorName() + ".*"
          + ReduceSinkOperator.getOperatorName()), np);
    }

    /*
     * Determine if there is only one TableScanOperator.  Currently in Map vectorization, we do not
     * try to vectorize multiple input trees.
     */
    private ImmutablePair<String, TableScanOperator> verifyOnlyOneTableScanOperator(MapWork mapWork) {

      // Eliminate MR plans with more than one TableScanOperator.

      LinkedHashMap<String, Operator<? extends OperatorDesc>> aliasToWork = mapWork.getAliasToWork();
      if ((aliasToWork == null) || (aliasToWork.size() == 0)) {
        return null;
      }
      int tableScanCount = 0;
      String alias = "";
      TableScanOperator tableScanOperator = null;
      for (Entry<String, Operator<? extends OperatorDesc>> entry : aliasToWork.entrySet()) {
        Operator<?> op = entry.getValue();
        if (op == null) {
          LOG.warn("Map work has invalid aliases to work with. Fail validation!");
          return null;
        }
        if (op instanceof TableScanOperator) {
          tableScanCount++;
          alias = entry.getKey();
          tableScanOperator = (TableScanOperator) op;
        }
      }
      if (tableScanCount > 1) {
        LOG.warn("Map work has more than 1 TableScanOperator. Fail validation!");
        return null;
      }
      return new ImmutablePair(alias, tableScanOperator);
    }

    private void getTableScanOperatorSchemaInfo(TableScanOperator tableScanOperator,
        List<String> logicalColumnNameList, List<TypeInfo> logicalTypeInfoList) {

      // Add all non-virtual columns to make a vectorization context for
      // the TableScan operator.
      RowSchema rowSchema = tableScanOperator.getSchema();
      for (ColumnInfo c : rowSchema.getSignature()) {
        // Validation will later exclude vectorization of virtual columns usage (HIVE-5560).
        if (!isVirtualColumn(c)) {
          String columnName = c.getInternalName();
          String typeName = c.getTypeName();
          TypeInfo typeInfo = TypeInfoUtils.getTypeInfoFromTypeString(typeName);

          logicalColumnNameList.add(columnName);
          logicalTypeInfoList.add(typeInfo);
        }
      }
    }

    private void determineDataColumnNums(TableScanOperator tableScanOperator,
        List<String> allColumnNameList, int dataColumnCount, List<Integer> dataColumnNums) {

      /*
       * The TableScanOperator's needed columns are just the data columns.
       */
      Set<String> neededColumns = new HashSet<String>(tableScanOperator.getNeededColumns());

      for (int dataColumnNum = 0; dataColumnNum < dataColumnCount; dataColumnNum++) {
        String columnName = allColumnNameList.get(dataColumnNum);
        if (neededColumns.contains(columnName)) {
          dataColumnNums.add(dataColumnNum);
        }
      }
    }

    private String getHiveOptionsString() {
      StringBuilder sb = new StringBuilder();
      sb.append(HiveConf.ConfVars.HIVE_VECTORIZATION_USE_VECTORIZED_INPUT_FILE_FORMAT.varname);
      sb.append("=");
      sb.append(useVectorizedInputFileFormat);
      sb.append(", ");
      sb.append(HiveConf.ConfVars.HIVE_VECTORIZATION_USE_VECTOR_DESERIALIZE.varname);
      sb.append("=");
      sb.append(useVectorDeserialize);
      sb.append(", and ");
      sb.append(HiveConf.ConfVars.HIVE_VECTORIZATION_USE_ROW_DESERIALIZE.varname);
      sb.append("=");
      sb.append(useRowDeserialize);
      return sb.toString();
    }

    /*
     * There are 3 modes of reading for vectorization:
     *
     *   1) One for the Vectorized Input File Format which returns VectorizedRowBatch as the row.
     *
     *   2) One for using VectorDeserializeRow to deserialize each row into the VectorizedRowBatch.
     *      Currently, these Input File Formats:
     *        TEXTFILE
     *        SEQUENCEFILE
     *
     *   3) And one using the regular partition deserializer to get the row object and assigning
     *      the row object into the VectorizedRowBatch with VectorAssignRow.
     *      This picks up Input File Format not supported by the other two.
     */
    private boolean verifyAndSetVectorPartDesc(PartitionDesc pd, boolean isAcidTable) {

      String inputFileFormatClassName = pd.getInputFileFormatClassName();

      // Look for Pass-Thru case where InputFileFormat has VectorizedInputFormatInterface
      // and reads VectorizedRowBatch as a "row".

      if (isAcidTable || useVectorizedInputFileFormat) {

        if (Utilities.isInputFileFormatVectorized(pd)) {

          if (!useVectorizedInputFileFormat) {
            LOG.info("ACID tables con only be vectorized for the input file format -- " +
                "i.e. when Hive Configuration option " +
                HiveConf.ConfVars.HIVE_VECTORIZATION_USE_VECTORIZED_INPUT_FILE_FORMAT.varname +
                "=true");
            return false;
          }

          pd.setVectorPartitionDesc(
              VectorPartitionDesc.createVectorizedInputFileFormat(
                  inputFileFormatClassName, Utilities.isInputFileFormatSelfDescribing(pd)));

          return true;
        }

        // Today, ACID tables are only ORC and that format is vectorizable.  Verify this
        // assumption.
        Preconditions.checkState(!isAcidTable);
      }

      if (!(isSchemaEvolution || isAcidTable) &&
        (useVectorDeserialize || useRowDeserialize)) {
        LOG.info("Input format: " + inputFileFormatClassName + " cannot be vectorized" +
            " when both " + HiveConf.ConfVars.HIVE_SCHEMA_EVOLUTION.varname + "=false and " +
            " ACID table is " + isAcidTable + " and " +
            " given the Hive Configuration options " + getHiveOptionsString());
        return false;
      }

      String deserializerClassName = pd.getDeserializerClassName();

      // Look for InputFileFormat / Serde combinations we can deserialize more efficiently
      // using VectorDeserializeRow and a deserialize class with the DeserializeRead interface.
      //
      // Do the "vectorized" row-by-row deserialization into a VectorizedRowBatch in the
      // VectorMapOperator.

      if (useVectorDeserialize) {

        // Currently, we support LazySimple deserialization:
        //
        //    org.apache.hadoop.mapred.TextInputFormat
        //    org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe
        //
        // AND
        //
        //    org.apache.hadoop.mapred.SequenceFileInputFormat
        //    org.apache.hadoop.hive.serde2.lazybinary.LazyBinarySerDe

        if (inputFileFormatClassName.equals(TextInputFormat.class.getName()) &&
            deserializerClassName.equals(LazySimpleSerDe.class.getName())) {

          pd.setVectorPartitionDesc(
              VectorPartitionDesc.createVectorDeserialize(
                  inputFileFormatClassName, VectorDeserializeType.LAZY_SIMPLE));

          return true;
        } else if (inputFileFormatClassName.equals(SequenceFileInputFormat.class.getName()) &&
            deserializerClassName.equals(LazyBinarySerDe.class.getName())) {

          pd.setVectorPartitionDesc(
              VectorPartitionDesc.createVectorDeserialize(
                  inputFileFormatClassName, VectorDeserializeType.LAZY_BINARY));

          return true;
        }
      }

      // Otherwise, if enabled, deserialize rows using regular Serde and add the object
      // inspect-able Object[] row to a VectorizedRowBatch in the VectorMapOperator.

      if (useRowDeserialize) {

        pd.setVectorPartitionDesc(
            VectorPartitionDesc.createRowDeserialize(
                inputFileFormatClassName,
                Utilities.isInputFileFormatSelfDescribing(pd),
                deserializerClassName));

        return true;

      }

      LOG.info("Input format: " + inputFileFormatClassName + " cannot be vectorized" +
          " given the Hive Configuration options " + getHiveOptionsString());

      return false;
    }

    private boolean validateInputFormatAndSchemaEvolution(MapWork mapWork, String alias,
        TableScanOperator tableScanOperator, VectorTaskColumnInfo vectorTaskColumnInfo)
            throws SemanticException {

      boolean isAcidTable = tableScanOperator.getConf().isAcidTable();

      // These names/types are the data columns plus partition columns.
      final List<String> allColumnNameList = new ArrayList<String>();
      final List<TypeInfo> allTypeInfoList = new ArrayList<TypeInfo>();

      getTableScanOperatorSchemaInfo(tableScanOperator, allColumnNameList, allTypeInfoList);

      final List<Integer> dataColumnNums = new ArrayList<Integer>();

      final int allColumnCount = allColumnNameList.size();

      /*
       * Validate input formats of all the partitions can be vectorized.
       */
      boolean isFirst = true;
      int dataColumnCount = 0;
      int partitionColumnCount = 0;

      List<String> tableDataColumnList = null;
      List<TypeInfo> tableDataTypeInfoList = null;

      LinkedHashMap<Path, ArrayList<String>> pathToAliases = mapWork.getPathToAliases();
      LinkedHashMap<Path, PartitionDesc> pathToPartitionInfo = mapWork.getPathToPartitionInfo();
      for (Entry<Path, ArrayList<String>> entry: pathToAliases.entrySet()) {
        Path path = entry.getKey();
        List<String> aliases = entry.getValue();
        boolean isPresent = (aliases != null && aliases.indexOf(alias) != -1);
        if (!isPresent) {
          LOG.info("Alias " + alias + " not present in aliases " + aliases);
          return false;
        }
        PartitionDesc partDesc = pathToPartitionInfo.get(path);
        if (partDesc.getVectorPartitionDesc() != null) {
          // We seen this already.
          continue;
        }
        if (!verifyAndSetVectorPartDesc(partDesc, isAcidTable)) {
          return false;
        }
        VectorPartitionDesc vectorPartDesc = partDesc.getVectorPartitionDesc();
        if (LOG.isInfoEnabled()) {
          LOG.info("Vectorizer path: " + path + ", " + vectorPartDesc.toString() +
              ", aliases " + aliases);
        }

        if (isFirst) {

          // Determine the data and partition columns using the first partition descriptor.

          LinkedHashMap<String, String> partSpec = partDesc.getPartSpec();
          if (partSpec != null && partSpec.size() > 0) {
            partitionColumnCount = partSpec.size();
            dataColumnCount = allColumnCount - partitionColumnCount;
          } else {
            partitionColumnCount = 0;
            dataColumnCount = allColumnCount;
          }

          determineDataColumnNums(tableScanOperator, allColumnNameList, dataColumnCount,
              dataColumnNums);

          tableDataColumnList = allColumnNameList.subList(0, dataColumnCount);
          tableDataTypeInfoList = allTypeInfoList.subList(0, dataColumnCount);

          isFirst = false;
        }

        // We need to get the partition's column names from the partition serde.
        // (e.g. Avro provides the table schema and ignores the partition schema..).
        //
        Deserializer deserializer;
        StructObjectInspector partObjectInspector;
        try {
          deserializer = partDesc.getDeserializer(hiveConf);
          partObjectInspector = (StructObjectInspector) deserializer.getObjectInspector();
        } catch (Exception e) {
          throw new SemanticException(e);
        }
        String nextDataColumnsString = ObjectInspectorUtils.getFieldNames(partObjectInspector);
        String[] nextDataColumns = nextDataColumnsString.split(",");
        List<String> nextDataColumnList = Arrays.asList(nextDataColumns);

        /*
         * Validate the column names that are present are the same.  Missing columns will be
         * implicitly defaulted to null.
         */
        if (nextDataColumnList.size() > tableDataColumnList.size()) {
          LOG.info(
              String.format(
                  "Could not vectorize partition %s " +
                  "(deserializer " + deserializer.getClass().getName() + ")" +
                  "The partition column names %d is greater than the number of table columns %d",
                  path, nextDataColumnList.size(), tableDataColumnList.size()));
          return false;
        }
        if (!(deserializer instanceof NullStructSerDe)) {

          // (Don't insist NullStructSerDe produce correct column names).
          for (int i = 0; i < nextDataColumnList.size(); i++) {
            String nextColumnName = nextDataColumnList.get(i);
            String tableColumnName = tableDataColumnList.get(i);
            if (!nextColumnName.equals(tableColumnName)) {
              LOG.info(
                  String.format(
                      "Could not vectorize partition %s " +
                      "(deserializer " + deserializer.getClass().getName() + ")" +
                      "The partition column name %s is does not match table column name %s",
                      path, nextColumnName, tableColumnName));
              return false;
            }
          }
        }

        List<TypeInfo> nextDataTypeInfoList;
        if (vectorPartDesc.getIsInputFileFormatSelfDescribing()) {

          /*
           * Self-Describing Input Format will convert its data to the table schema.
           */
          nextDataTypeInfoList = tableDataTypeInfoList;

        } else {
          String nextDataTypesString = ObjectInspectorUtils.getFieldTypes(partObjectInspector);

          // We convert to an array of TypeInfo using a library routine since it parses the information
          // and can handle use of different separators, etc.  We cannot use the raw type string
          // for comparison in the map because of the different separators used.
          nextDataTypeInfoList =
              TypeInfoUtils.getTypeInfosFromTypeString(nextDataTypesString);
        }

        vectorPartDesc.setDataTypeInfos(nextDataTypeInfoList);
      }

      vectorTaskColumnInfo.setAllColumnNames(allColumnNameList);
      vectorTaskColumnInfo.setAllTypeInfos(allTypeInfoList);
      vectorTaskColumnInfo.setDataColumnNums(dataColumnNums);
      vectorTaskColumnInfo.setPartitionColumnCount(partitionColumnCount);
      vectorTaskColumnInfo.setUseVectorizedInputFileFormat(useVectorizedInputFileFormat);

      // Helps to keep this for debugging.
      vectorTaskColumnInfo.setTableScanOperator(tableScanOperator);

      return true;
    }

    private boolean validateMapWork(MapWork mapWork, VectorTaskColumnInfo vectorTaskColumnInfo, boolean isTez)
            throws SemanticException {

      LOG.info("Validating MapWork...");

      ImmutablePair<String,TableScanOperator> pair = verifyOnlyOneTableScanOperator(mapWork);
      if (pair ==  null) {
        return false;
      }
      String alias = pair.left;
      TableScanOperator tableScanOperator = pair.right;

      // This call fills in the column names, types, and partition column count in
      // vectorTaskColumnInfo.
      if (!validateInputFormatAndSchemaEvolution(mapWork, alias, tableScanOperator, vectorTaskColumnInfo)) {
        return false;
      }

      Map<Rule, NodeProcessor> opRules = new LinkedHashMap<Rule, NodeProcessor>();
      MapWorkValidationNodeProcessor vnp = new MapWorkValidationNodeProcessor(mapWork, isTez);
      addMapWorkRules(opRules, vnp);
      Dispatcher disp = new DefaultRuleDispatcher(vnp, opRules, null);
      GraphWalker ogw = new DefaultGraphWalker(disp);

      // iterator the mapper operator tree
      ArrayList<Node> topNodes = new ArrayList<Node>();
      topNodes.addAll(mapWork.getAliasToWork().values());
      HashMap<Node, Object> nodeOutput = new HashMap<Node, Object>();
      ogw.startWalking(topNodes, nodeOutput);
      for (Node n : nodeOutput.keySet()) {
        if (nodeOutput.get(n) != null) {
          if (!((Boolean)nodeOutput.get(n)).booleanValue()) {
            return false;
          }
        }
      }
      vectorTaskColumnInfo.setNonVectorizedOps(vnp.getNonVectorizedOps());
      return true;
    }

    private void vectorizeMapWork(MapWork mapWork, VectorTaskColumnInfo vectorTaskColumnInfo,
            boolean isTez) throws SemanticException {

      LOG.info("Vectorizing MapWork...");
      mapWork.setVectorMode(true);
      Map<Rule, NodeProcessor> opRules = new LinkedHashMap<Rule, NodeProcessor>();
      MapWorkVectorizationNodeProcessor vnp =
          new MapWorkVectorizationNodeProcessor(mapWork, isTez, vectorTaskColumnInfo);
      addMapWorkRules(opRules, vnp);
      Dispatcher disp = new DefaultRuleDispatcher(vnp, opRules, null);
      GraphWalker ogw = new PreOrderOnceWalker(disp);
      // iterator the mapper operator tree
      ArrayList<Node> topNodes = new ArrayList<Node>();
      topNodes.addAll(mapWork.getAliasToWork().values());
      HashMap<Node, Object> nodeOutput = new HashMap<Node, Object>();
      ogw.startWalking(topNodes, nodeOutput);

      vectorTaskColumnInfo.setScratchTypeNameArray(vnp.getVectorScratchColumnTypeNames());

      vectorTaskColumnInfo.transferToBaseWork(mapWork);

      if (LOG.isDebugEnabled()) {
        debugDisplayAllMaps(mapWork);
      }

      return;
    }

    private void convertReduceWork(ReduceWork reduceWork, boolean isTez) throws SemanticException {
      VectorTaskColumnInfo vectorTaskColumnInfo = new VectorTaskColumnInfo();
      boolean ret = validateReduceWork(reduceWork, vectorTaskColumnInfo, isTez);
      if (ret) {
        vectorizeReduceWork(reduceWork, vectorTaskColumnInfo, isTez);
      }
    }

    private boolean getOnlyStructObjectInspectors(ReduceWork reduceWork,
            VectorTaskColumnInfo vectorTaskColumnInfo) throws SemanticException {

      ArrayList<String> reduceColumnNames = new ArrayList<String>();
      ArrayList<TypeInfo> reduceTypeInfos = new ArrayList<TypeInfo>();

      try {
        // Check key ObjectInspector.
        ObjectInspector keyObjectInspector = reduceWork.getKeyObjectInspector();
        if (keyObjectInspector == null || !(keyObjectInspector instanceof StructObjectInspector)) {
          return false;
        }
        StructObjectInspector keyStructObjectInspector = (StructObjectInspector)keyObjectInspector;
        List<? extends StructField> keyFields = keyStructObjectInspector.getAllStructFieldRefs();

        // Tez doesn't use tagging...
        if (reduceWork.getNeedsTagging()) {
          return false;
        }

        // Check value ObjectInspector.
        ObjectInspector valueObjectInspector = reduceWork.getValueObjectInspector();
        if (valueObjectInspector == null ||
                !(valueObjectInspector instanceof StructObjectInspector)) {
          return false;
        }
        StructObjectInspector valueStructObjectInspector = (StructObjectInspector)valueObjectInspector;
        List<? extends StructField> valueFields = valueStructObjectInspector.getAllStructFieldRefs();

        for (StructField field: keyFields) {
          reduceColumnNames.add(Utilities.ReduceField.KEY.toString() + "." + field.getFieldName());
          reduceTypeInfos.add(TypeInfoUtils.getTypeInfoFromTypeString(field.getFieldObjectInspector().getTypeName()));
        }
        for (StructField field: valueFields) {
          reduceColumnNames.add(Utilities.ReduceField.VALUE.toString() + "." + field.getFieldName());
          reduceTypeInfos.add(TypeInfoUtils.getTypeInfoFromTypeString(field.getFieldObjectInspector().getTypeName()));
        }
      } catch (Exception e) {
        throw new SemanticException(e);
      }

      vectorTaskColumnInfo.setAllColumnNames(reduceColumnNames);
      vectorTaskColumnInfo.setAllTypeInfos(reduceTypeInfos);

      return true;
    }

    private void addReduceWorkRules(Map<Rule, NodeProcessor> opRules, NodeProcessor np) {
      opRules.put(new RuleRegExp("R1", GroupByOperator.getOperatorName() + ".*"), np);
      opRules.put(new RuleRegExp("R2", SelectOperator.getOperatorName() + ".*"), np);
    }

    private boolean validateReduceWork(ReduceWork reduceWork,
        VectorTaskColumnInfo vectorTaskColumnInfo, boolean isTez) throws SemanticException {

      LOG.info("Validating ReduceWork...");

      // Validate input to ReduceWork.
      if (!getOnlyStructObjectInspectors(reduceWork, vectorTaskColumnInfo)) {
        return false;
      }
      // Now check the reduce operator tree.
      Map<Rule, NodeProcessor> opRules = new LinkedHashMap<Rule, NodeProcessor>();
      ReduceWorkValidationNodeProcessor vnp = new ReduceWorkValidationNodeProcessor();
      addReduceWorkRules(opRules, vnp);
      Dispatcher disp = new DefaultRuleDispatcher(vnp, opRules, null);
      GraphWalker ogw = new DefaultGraphWalker(disp);
      // iterator the reduce operator tree
      ArrayList<Node> topNodes = new ArrayList<Node>();
      topNodes.add(reduceWork.getReducer());
      HashMap<Node, Object> nodeOutput = new HashMap<Node, Object>();
      ogw.startWalking(topNodes, nodeOutput);
      for (Node n : nodeOutput.keySet()) {
        if (nodeOutput.get(n) != null) {
          if (!((Boolean)nodeOutput.get(n)).booleanValue()) {
            return false;
          }
        }
      }
      vectorTaskColumnInfo.setNonVectorizedOps(vnp.getNonVectorizedOps());
      return true;
    }

    private void vectorizeReduceWork(ReduceWork reduceWork,
        VectorTaskColumnInfo vectorTaskColumnInfo, boolean isTez) throws SemanticException {

      LOG.info("Vectorizing ReduceWork...");
      reduceWork.setVectorMode(true);

      // For some reason, the DefaultGraphWalker does not descend down from the reducer Operator as
      // expected.  We need to descend down, otherwise it breaks our algorithm that determines
      // VectorizationContext...  Do we use PreOrderWalker instead of DefaultGraphWalker.
      Map<Rule, NodeProcessor> opRules = new LinkedHashMap<Rule, NodeProcessor>();
      ReduceWorkVectorizationNodeProcessor vnp =
              new ReduceWorkVectorizationNodeProcessor(vectorTaskColumnInfo, isTez);
      addReduceWorkRules(opRules, vnp);
      Dispatcher disp = new DefaultRuleDispatcher(vnp, opRules, null);
      GraphWalker ogw = new PreOrderWalker(disp);
      // iterator the reduce operator tree
      ArrayList<Node> topNodes = new ArrayList<Node>();
      topNodes.add(reduceWork.getReducer());
      LOG.info("vectorizeReduceWork reducer Operator: " +
              reduceWork.getReducer().getName() + "...");
      HashMap<Node, Object> nodeOutput = new HashMap<Node, Object>();
      ogw.startWalking(topNodes, nodeOutput);

      // Necessary since we are vectorizing the root operator in reduce.
      reduceWork.setReducer(vnp.getRootVectorOp());

      vectorTaskColumnInfo.setScratchTypeNameArray(vnp.getVectorScratchColumnTypeNames());

      vectorTaskColumnInfo.transferToBaseWork(reduceWork);

      if (LOG.isDebugEnabled()) {
        debugDisplayAllMaps(reduceWork);
      }
    }
  }

  class MapWorkValidationNodeProcessor implements NodeProcessor {

    private final MapWork mapWork;
    private final boolean isTez;

    // Children of Vectorized GROUPBY that outputs rows instead of vectorized row batchs.
    protected final Set<Operator<? extends OperatorDesc>> nonVectorizedOps =
        new HashSet<Operator<? extends OperatorDesc>>();

    public Set<Operator<? extends OperatorDesc>> getNonVectorizedOps() {
      return nonVectorizedOps;
    }

    public MapWorkValidationNodeProcessor(MapWork mapWork, boolean isTez) {
      this.mapWork = mapWork;
      this.isTez = isTez;
    }

    @Override
    public Object process(Node nd, Stack<Node> stack, NodeProcessorCtx procCtx,
        Object... nodeOutputs) throws SemanticException {
      for (Node n : stack) {
        Operator<? extends OperatorDesc> op = (Operator<? extends OperatorDesc>) n;
        if (nonVectorizedOps.contains(op)) {
          return new Boolean(true);
        }
        boolean ret;
        try {
          ret = validateMapWorkOperator(op, mapWork, isTez);
        } catch (Exception e) {
          throw new SemanticException(e);
        }
        if (!ret) {
          LOG.info("MapWork Operator: " + op.getName() + " could not be vectorized.");
          return new Boolean(false);
        }
        // When Vectorized GROUPBY outputs rows instead of vectorized row batches, we don't
        // vectorize the operators below it.
        if (isVectorizedGroupByThatOutputsRows(op)) {
          addOperatorChildrenToSet(op, nonVectorizedOps);
          return new Boolean(true);
        }
      }
      return new Boolean(true);
    }
  }

  class ReduceWorkValidationNodeProcessor implements NodeProcessor {

    // Children of Vectorized GROUPBY that outputs rows instead of vectorized row batchs.
    protected final Set<Operator<? extends OperatorDesc>> nonVectorizedOps =
        new HashSet<Operator<? extends OperatorDesc>>();

    public Set<Operator<? extends OperatorDesc>> getNonVectorizeOps() {
      return nonVectorizedOps;
    }

    public Set<Operator<? extends OperatorDesc>> getNonVectorizedOps() {
      return nonVectorizedOps;
    }

    @Override
    public Object process(Node nd, Stack<Node> stack, NodeProcessorCtx procCtx,
        Object... nodeOutputs) throws SemanticException {
      for (Node n : stack) {
        Operator<? extends OperatorDesc> op = (Operator<? extends OperatorDesc>) n;
        if (nonVectorizedOps.contains(op)) {
          return new Boolean(true);
        }
        boolean ret = validateReduceWorkOperator(op);
        if (!ret) {
          LOG.info("ReduceWork Operator: " + op.getName() + " could not be vectorized.");
          return new Boolean(false);
        }
        // When Vectorized GROUPBY outputs rows instead of vectorized row batches, we don't
        // vectorize the operators below it.
        if (isVectorizedGroupByThatOutputsRows(op)) {
          addOperatorChildrenToSet(op, nonVectorizedOps);
          return new Boolean(true);
        }
      }
      return new Boolean(true);
    }
  }

  // This class has common code used by both MapWorkVectorizationNodeProcessor and
  // ReduceWorkVectorizationNodeProcessor.
  class VectorizationNodeProcessor implements NodeProcessor {

    // The vectorization context for the Map or Reduce task.
    protected VectorizationContext taskVectorizationContext;

    protected final Set<Operator<? extends OperatorDesc>> nonVectorizedOps;

    VectorizationNodeProcessor(Set<Operator<? extends OperatorDesc>> nonVectorizedOps) {
      this.nonVectorizedOps = nonVectorizedOps;
    }

    public String[] getVectorScratchColumnTypeNames() {
      return taskVectorizationContext.getScratchColumnTypeNames();
    }

    protected final Set<Operator<? extends OperatorDesc>> opsDone =
        new HashSet<Operator<? extends OperatorDesc>>();

    protected final Map<Operator<? extends OperatorDesc>, Operator<? extends OperatorDesc>> opToVectorOpMap =
        new HashMap<Operator<? extends OperatorDesc>, Operator<? extends OperatorDesc>>();

    public VectorizationContext walkStackToFindVectorizationContext(Stack<Node> stack,
            Operator<? extends OperatorDesc> op) throws SemanticException {
      VectorizationContext vContext = null;
      if (stack.size() <= 1) {
        throw new SemanticException(
            String.format("Expected operator stack for operator %s to have at least 2 operators",
                  op.getName()));
      }
      // Walk down the stack of operators until we found one willing to give us a context.
      // At the bottom will be the root operator, guaranteed to have a context
      int i= stack.size()-2;
      while (vContext == null) {
        if (i < 0) {
          return null;
        }
        Operator<? extends OperatorDesc> opParent = (Operator<? extends OperatorDesc>) stack.get(i);
        Operator<? extends OperatorDesc> vectorOpParent = opToVectorOpMap.get(opParent);
        if (vectorOpParent != null) {
          if (vectorOpParent instanceof VectorizationContextRegion) {
            VectorizationContextRegion vcRegion = (VectorizationContextRegion) vectorOpParent;
            vContext = vcRegion.getOuputVectorizationContext();
            LOG.info("walkStackToFindVectorizationContext " + vectorOpParent.getName() + " has new vectorization context " + vContext.toString());
          } else {
            LOG.info("walkStackToFindVectorizationContext " + vectorOpParent.getName() + " does not have new vectorization context");
          }
        } else {
          LOG.info("walkStackToFindVectorizationContext " + opParent.getName() + " is not vectorized");
        }
        --i;
      }
      return vContext;
    }

    public Operator<? extends OperatorDesc> doVectorize(Operator<? extends OperatorDesc> op,
            VectorizationContext vContext, boolean isTez) throws SemanticException {
      Operator<? extends OperatorDesc> vectorOp = op;
      try {
        if (!opsDone.contains(op)) {
          vectorOp = vectorizeOperator(op, vContext, isTez);
          opsDone.add(op);
          if (vectorOp != op) {
            opToVectorOpMap.put(op, vectorOp);
            opsDone.add(vectorOp);
          }
        }
      } catch (HiveException e) {
        throw new SemanticException(e);
      }
      return vectorOp;
    }

    @Override
    public Object process(Node nd, Stack<Node> stack, NodeProcessorCtx procCtx,
        Object... nodeOutputs) throws SemanticException {
      throw new SemanticException("Must be overridden");
    }
  }

  class MapWorkVectorizationNodeProcessor extends VectorizationNodeProcessor {

    private final MapWork mWork;
    private final VectorTaskColumnInfo vectorTaskColumnInfo;
    private final boolean isTez;

    public MapWorkVectorizationNodeProcessor(MapWork mWork, boolean isTez,
        VectorTaskColumnInfo vectorTaskColumnInfo) {
      super(vectorTaskColumnInfo.getNonVectorizedOps());
      this.mWork = mWork;
      this.vectorTaskColumnInfo = vectorTaskColumnInfo;
      this.isTez = isTez;
    }

    @Override
    public Object process(Node nd, Stack<Node> stack, NodeProcessorCtx procCtx,
        Object... nodeOutputs) throws SemanticException {

      Operator<? extends OperatorDesc> op = (Operator<? extends OperatorDesc>) nd;
      if (nonVectorizedOps.contains(op)) {
        return null;
      }

      VectorizationContext vContext = null;

      if (op instanceof TableScanOperator) {
        if (taskVectorizationContext == null) {
          taskVectorizationContext = getVectorizationContext(op.getName(), vectorTaskColumnInfo);
        }
        vContext = taskVectorizationContext;
      } else {
        LOG.debug("MapWorkVectorizationNodeProcessor process going to walk the operator stack to get vectorization context for " + op.getName());
        vContext = walkStackToFindVectorizationContext(stack, op);
        if (vContext == null) {
          // No operator has "pushed" a new context -- so use the task vectorization context.
          vContext = taskVectorizationContext;
        }
      }

      assert vContext != null;
      if (LOG.isDebugEnabled()) {
        LOG.debug("MapWorkVectorizationNodeProcessor process operator " + op.getName()
            + " using vectorization context" + vContext.toString());
      }

      Operator<? extends OperatorDesc> vectorOp = doVectorize(op, vContext, isTez);

      if (LOG.isDebugEnabled()) {
        if (vectorOp instanceof VectorizationContextRegion) {
          VectorizationContextRegion vcRegion = (VectorizationContextRegion) vectorOp;
          VectorizationContext vNewContext = vcRegion.getOuputVectorizationContext();
          LOG.debug("Vectorized MapWork operator " + vectorOp.getName() + " added vectorization context " + vNewContext.toString());
        }
      }

      return null;
    }
  }

  class ReduceWorkVectorizationNodeProcessor extends VectorizationNodeProcessor {

    private final VectorTaskColumnInfo vectorTaskColumnInfo;

    private final boolean isTez;

    private Operator<? extends OperatorDesc> rootVectorOp;

    public Operator<? extends OperatorDesc> getRootVectorOp() {
      return rootVectorOp;
    }

    public ReduceWorkVectorizationNodeProcessor(VectorTaskColumnInfo vectorTaskColumnInfo,
            boolean isTez) {

      super(vectorTaskColumnInfo.getNonVectorizedOps());
      this.vectorTaskColumnInfo =  vectorTaskColumnInfo;
      rootVectorOp = null;
      this.isTez = isTez;
    }

    @Override
    public Object process(Node nd, Stack<Node> stack, NodeProcessorCtx procCtx,
        Object... nodeOutputs) throws SemanticException {

      Operator<? extends OperatorDesc> op = (Operator<? extends OperatorDesc>) nd;
      if (nonVectorizedOps.contains(op)) {
        return null;
      }

      VectorizationContext vContext = null;

      boolean saveRootVectorOp = false;

      if (op.getParentOperators().size() == 0) {
        LOG.info("ReduceWorkVectorizationNodeProcessor process reduceColumnNames " + vectorTaskColumnInfo.allColumnNames.toString());

        vContext = new VectorizationContext("__Reduce_Shuffle__", vectorTaskColumnInfo.allColumnNames, hiveConf);
        taskVectorizationContext = vContext;

        saveRootVectorOp = true;

        if (LOG.isDebugEnabled()) {
          LOG.debug("Vectorized ReduceWork reduce shuffle vectorization context " + vContext.toString());
        }
      } else {
        LOG.info("ReduceWorkVectorizationNodeProcessor process going to walk the operator stack to get vectorization context for " + op.getName());
        vContext = walkStackToFindVectorizationContext(stack, op);
        if (vContext == null) {
          // If we didn't find a context among the operators, assume the top -- reduce shuffle's
          // vectorization context.
          vContext = taskVectorizationContext;
        }
      }

      assert vContext != null;
      LOG.info("ReduceWorkVectorizationNodeProcessor process operator " + op.getName() + " using vectorization context" + vContext.toString());

      Operator<? extends OperatorDesc> vectorOp = doVectorize(op, vContext, isTez);

      if (LOG.isDebugEnabled()) {
        if (vectorOp instanceof VectorizationContextRegion) {
          VectorizationContextRegion vcRegion = (VectorizationContextRegion) vectorOp;
          VectorizationContext vNewContext = vcRegion.getOuputVectorizationContext();
          LOG.debug("Vectorized ReduceWork operator " + vectorOp.getName() + " added vectorization context " + vNewContext.toString());
        }
      }
      if (saveRootVectorOp && op != vectorOp) {
        rootVectorOp = vectorOp;
      }

      return null;
    }
  }

  private static class ValidatorVectorizationContext extends VectorizationContext {
    private ValidatorVectorizationContext(HiveConf hiveConf) {
      super("No Name", hiveConf);
    }

    @Override
    protected int getInputColumnIndex(String name) {
      return 0;
    }

    @Override
    protected int getInputColumnIndex(ExprNodeColumnDesc colExpr) {
      return 0;
    }
  }

  @Override
  public PhysicalContext resolve(PhysicalContext physicalContext) throws SemanticException {

    hiveConf = physicalContext.getConf();

    boolean vectorPath = HiveConf.getBoolVar(hiveConf,
        HiveConf.ConfVars.HIVE_VECTORIZATION_ENABLED);
    if (!vectorPath) {
      LOG.info("Vectorization is disabled");
      return physicalContext;
    }

    isSpark = (HiveConf.getVar(hiveConf, HiveConf.ConfVars.HIVE_EXECUTION_ENGINE).equals("spark"));

    useVectorizedInputFileFormat =
        HiveConf.getBoolVar(hiveConf,
            HiveConf.ConfVars.HIVE_VECTORIZATION_USE_VECTORIZED_INPUT_FILE_FORMAT);
    useVectorDeserialize =
        HiveConf.getBoolVar(hiveConf,
            HiveConf.ConfVars.HIVE_VECTORIZATION_USE_VECTOR_DESERIALIZE);
    useRowDeserialize =
        HiveConf.getBoolVar(hiveConf,
            HiveConf.ConfVars.HIVE_VECTORIZATION_USE_ROW_DESERIALIZE);

    isSchemaEvolution =
        HiveConf.getBoolVar(hiveConf,
            HiveConf.ConfVars.HIVE_SCHEMA_EVOLUTION);

    // create dispatcher and graph walker
    Dispatcher disp = new VectorizationDispatcher(physicalContext);
    TaskGraphWalker ogw = new TaskGraphWalker(disp);

    // get all the tasks nodes from root task
    ArrayList<Node> topNodes = new ArrayList<Node>();
    topNodes.addAll(physicalContext.getRootTasks());

    // begin to walk through the task tree.
    ogw.startWalking(topNodes, null);
    return physicalContext;
  }

  boolean validateMapWorkOperator(Operator<? extends OperatorDesc> op, MapWork mWork, boolean isTez) {
    boolean ret = false;
    switch (op.getType()) {
      case MAPJOIN:
        if (op instanceof MapJoinOperator) {
          ret = validateMapJoinOperator((MapJoinOperator) op);
        } else if (op instanceof SMBMapJoinOperator) {
          ret = validateSMBMapJoinOperator((SMBMapJoinOperator) op);
        }
        break;
      case GROUPBY:
        ret = validateGroupByOperator((GroupByOperator) op, false, isTez);
        break;
      case FILTER:
        ret = validateFilterOperator((FilterOperator) op);
        break;
      case SELECT:
        ret = validateSelectOperator((SelectOperator) op);
        break;
      case REDUCESINK:
        ret = validateReduceSinkOperator((ReduceSinkOperator) op);
        break;
      case TABLESCAN:
        ret = validateTableScanOperator((TableScanOperator) op, mWork);
        break;
      case FILESINK:
      case LIMIT:
      case EVENT:
      case SPARKPRUNINGSINK:
        ret = true;
        break;
      case HASHTABLESINK:
        ret = op instanceof SparkHashTableSinkOperator &&
            validateSparkHashTableSinkOperator((SparkHashTableSinkOperator) op);
        break;
      default:
        ret = false;
        break;
    }
    return ret;
  }

  boolean validateReduceWorkOperator(Operator<? extends OperatorDesc> op) {
    boolean ret = false;
    switch (op.getType()) {
      case MAPJOIN:
        // Does MAPJOIN actually get planned in Reduce?
        if (op instanceof MapJoinOperator) {
          ret = validateMapJoinOperator((MapJoinOperator) op);
        } else if (op instanceof SMBMapJoinOperator) {
          ret = validateSMBMapJoinOperator((SMBMapJoinOperator) op);
        }
        break;
      case GROUPBY:
        if (HiveConf.getBoolVar(hiveConf,
                    HiveConf.ConfVars.HIVE_VECTORIZATION_REDUCE_GROUPBY_ENABLED)) {
          ret = validateGroupByOperator((GroupByOperator) op, true, true);
        } else {
          ret = false;
        }
        break;
      case FILTER:
        ret = validateFilterOperator((FilterOperator) op);
        break;
      case SELECT:
        ret = validateSelectOperator((SelectOperator) op);
        break;
      case REDUCESINK:
        ret = validateReduceSinkOperator((ReduceSinkOperator) op);
        break;
      case FILESINK:
        ret = validateFileSinkOperator((FileSinkOperator) op);
        break;
      case LIMIT:
      case EVENT:
      case SPARKPRUNINGSINK:
        ret = true;
        break;
      case HASHTABLESINK:
        ret = op instanceof SparkHashTableSinkOperator &&
            validateSparkHashTableSinkOperator((SparkHashTableSinkOperator) op);
        break;
      default:
        ret = false;
        break;
    }
    return ret;
  }

  private void addOperatorChildrenToSet(Operator<? extends OperatorDesc> op,
      Set<Operator<? extends OperatorDesc>> nonVectorizedOps) {
    for (Operator<? extends OperatorDesc> childOp : op.getChildOperators()) {
      if (!nonVectorizedOps.contains(childOp)) {
        nonVectorizedOps.add(childOp);
        addOperatorChildrenToSet(childOp, nonVectorizedOps);
      }
    }
  }

  // When Vectorized GROUPBY outputs rows instead of vectorized row batchs, we don't
  // vectorize the operators below it.
   private Boolean isVectorizedGroupByThatOutputsRows(Operator<? extends OperatorDesc> op)
      throws SemanticException {
    if (op.getType().equals(OperatorType.GROUPBY)) {
      GroupByDesc desc = (GroupByDesc) op.getConf();
      return !desc.getVectorDesc().isVectorOutput();
    }
    return false;
  }

  private boolean validateSMBMapJoinOperator(SMBMapJoinOperator op) {
    SMBJoinDesc desc = op.getConf();
    // Validation is the same as for map join, since the 'small' tables are not vectorized
    return validateMapJoinDesc(desc);
  }

  private boolean validateTableScanOperator(TableScanOperator op, MapWork mWork) {
    TableScanDesc desc = op.getConf();
    if (desc.isGatherStats()) {
      return false;
    }

    return true;
  }

  private boolean validateMapJoinOperator(MapJoinOperator op) {
    MapJoinDesc desc = op.getConf();
    return validateMapJoinDesc(desc);
  }

  private boolean validateMapJoinDesc(MapJoinDesc desc) {
    byte posBigTable = (byte) desc.getPosBigTable();
    List<ExprNodeDesc> filterExprs = desc.getFilters().get(posBigTable);
    if (!validateExprNodeDesc(filterExprs, VectorExpressionDescriptor.Mode.FILTER)) {
      LOG.info("Cannot vectorize map work filter expression");
      return false;
    }
    List<ExprNodeDesc> keyExprs = desc.getKeys().get(posBigTable);
    if (!validateExprNodeDesc(keyExprs)) {
      LOG.info("Cannot vectorize map work key expression");
      return false;
    }
    List<ExprNodeDesc> valueExprs = desc.getExprs().get(posBigTable);
    if (!validateExprNodeDesc(valueExprs)) {
      LOG.info("Cannot vectorize map work value expression");
      return false;
    }
    Byte[] order = desc.getTagOrder();
    Byte posSingleVectorMapJoinSmallTable = (order[0] == posBigTable ? order[1] : order[0]);
    List<ExprNodeDesc> smallTableExprs = desc.getExprs().get(posSingleVectorMapJoinSmallTable);
    if (!validateExprNodeDesc(smallTableExprs)) {
      LOG.info("Cannot vectorize map work small table expression");
      return false;
    }
    return true;
  }

  private boolean validateSparkHashTableSinkOperator(SparkHashTableSinkOperator op) {
    SparkHashTableSinkDesc desc = op.getConf();
    byte tag = desc.getTag();
    // it's essentially a MapJoinDesc
    List<ExprNodeDesc> filterExprs = desc.getFilters().get(tag);
    List<ExprNodeDesc> keyExprs = desc.getKeys().get(tag);
    List<ExprNodeDesc> valueExprs = desc.getExprs().get(tag);
    return validateExprNodeDesc(filterExprs, VectorExpressionDescriptor.Mode.FILTER) &&
        validateExprNodeDesc(keyExprs) && validateExprNodeDesc(valueExprs);
  }

  private boolean validateReduceSinkOperator(ReduceSinkOperator op) {
    List<ExprNodeDesc> keyDescs = op.getConf().getKeyCols();
    List<ExprNodeDesc> partitionDescs = op.getConf().getPartitionCols();
    List<ExprNodeDesc> valueDesc = op.getConf().getValueCols();
    return validateExprNodeDesc(keyDescs) && validateExprNodeDesc(partitionDescs) &&
        validateExprNodeDesc(valueDesc);
  }

  private boolean validateSelectOperator(SelectOperator op) {
    List<ExprNodeDesc> descList = op.getConf().getColList();
    for (ExprNodeDesc desc : descList) {
      boolean ret = validateExprNodeDesc(desc);
      if (!ret) {
        LOG.info("Cannot vectorize select expression: " + desc.toString());
        return false;
      }
    }
    return true;
  }

  private boolean validateFilterOperator(FilterOperator op) {
    ExprNodeDesc desc = op.getConf().getPredicate();
    return validateExprNodeDesc(desc, VectorExpressionDescriptor.Mode.FILTER);
  }

  private boolean validateGroupByOperator(GroupByOperator op, boolean isReduce, boolean isTez) {
    GroupByDesc desc = op.getConf();
    VectorGroupByDesc vectorDesc = desc.getVectorDesc();

    if (desc.isGroupingSetsPresent()) {
      LOG.info("Grouping sets not supported in vector mode");
      return false;
    }
    if (desc.pruneGroupingSetId()) {
      LOG.info("Pruning grouping set id not supported in vector mode");
      return false;
    }
    if (desc.getMode() != GroupByDesc.Mode.HASH && desc.isDistinct()) {
      LOG.info("DISTINCT not supported in vector mode");
      return false;
    }
    boolean ret = validateExprNodeDesc(desc.getKeys());
    if (!ret) {
      LOG.info("Cannot vectorize groupby key expression " + desc.getKeys().toString());
      return false;
    }

    /**
     *
     * GROUP BY DEFINITIONS:
     *
     * GroupByDesc.Mode enumeration:
     *
     *    The different modes of a GROUP BY operator.
     *
     *    These descriptions are hopefully less cryptic than the comments for GroupByDesc.Mode.
     *
     *        COMPLETE       Aggregates original rows into full aggregation row(s).
     *
     *                       If the key length is 0, this is also called Global aggregation and
     *                       1 output row is produced.
     *
     *                       When the key length is > 0, the original rows come in ALREADY GROUPED.
     *
     *                       An example for key length > 0 is a GROUP BY being applied to the
     *                       ALREADY GROUPED rows coming from an upstream JOIN operator.  Or,
     *                       ALREADY GROUPED rows coming from upstream MERGEPARTIAL GROUP BY
     *                       operator.
     *
     *        PARTIAL1       The first of 2 (or more) phases that aggregates ALREADY GROUPED
     *                       original rows into partial aggregations.
     *
     *                       Subsequent phases PARTIAL2 (optional) and MERGEPARTIAL will merge
     *                       the partial aggregations and output full aggregations.
     *
     *        PARTIAL2       Accept ALREADY GROUPED partial aggregations and merge them into another
     *                       partial aggregation.  Output the merged partial aggregations.
     *
     *                       (Haven't seen this one used)
     *
     *        PARTIALS       (Behaves for non-distinct the same as PARTIAL2; and behaves for
     *                       distinct the same as PARTIAL1.)
     *
     *        FINAL          Accept ALREADY GROUPED original rows and aggregate them into
     *                       full aggregations.
     *
     *                       Example is a GROUP BY being applied to rows from a sorted table, where
     *                       the group key is the table sort key (or a prefix).
     *
     *        HASH           Accept UNORDERED original rows and aggregate them into a memory table.
     *                       Output the partial aggregations on closeOp (or low memory).
     *
     *                       Similar to PARTIAL1 except original rows are UNORDERED.
     *
     *                       Commonly used in both Mapper and Reducer nodes.  Always followed by
     *                       a Reducer with MERGEPARTIAL GROUP BY.
     *
     *        MERGEPARTIAL   Always first operator of a Reducer.  Data is grouped by reduce-shuffle.
     *
     *                       (Behaves for non-distinct aggregations the same as FINAL; and behaves
     *                       for distinct aggregations the same as COMPLETE.)
     *
     *                       The output is full aggregation(s).
     *
     *                       Used in Reducers after a stage with a HASH GROUP BY operator.
     *
     *
     *  VectorGroupByDesc.ProcessingMode for VectorGroupByOperator:
     *
     *     GLOBAL         No key.  All rows --> 1 full aggregation on end of input
     *
     *     HASH           Rows aggregated in to hash table on group key -->
     *                        1 partial aggregation per key (normally, unless there is spilling)
     *
     *     MERGE_PARTIAL  As first operator in a REDUCER, partial aggregations come grouped from
     *                    reduce-shuffle -->
     *                        aggregate the partial aggregations and emit full aggregation on
     *                        endGroup / closeOp
     *
     *     STREAMING      Rows come from PARENT operator ALREADY GROUPED -->
     *                        aggregate the rows and emit full aggregation on key change / closeOp
     *
     *     NOTE: Hash can spill partial result rows prematurely if it runs low on memory.
     *     NOTE: Streaming has to compare keys where MergePartial gets an endGroup call.
     *
     *
     *  DECIDER: Which VectorGroupByDesc.ProcessingMode for VectorGroupByOperator?
     *
     *     Decides using GroupByDesc.Mode and whether there are keys with the
     *     VectorGroupByDesc.groupByDescModeToVectorProcessingMode method.
     *
     *         Mode.COMPLETE      --> (numKeys == 0 ? ProcessingMode.GLOBAL : ProcessingMode.STREAMING)
     *
     *         Mode.HASH          --> ProcessingMode.HASH
     *
     *         Mode.MERGEPARTIAL  --> (numKeys == 0 ? ProcessingMode.GLOBAL : ProcessingMode.MERGE_PARTIAL)
     *
     *         Mode.PARTIAL1,
     *         Mode.PARTIAL2,
     *         Mode.PARTIALS,
     *         Mode.FINAL        --> ProcessingMode.STREAMING
     *
     */
    boolean hasKeys = (desc.getKeys().size() > 0);

    ProcessingMode processingMode =
        VectorGroupByDesc.groupByDescModeToVectorProcessingMode(desc.getMode(), hasKeys);

    Pair<Boolean,Boolean> retPair =
        validateAggregationDescs(desc.getAggregators(), processingMode, hasKeys);
    if (!retPair.left) {
      return false;
    }

    // If all the aggregation outputs are primitive, we can output VectorizedRowBatch.
    // Otherwise, we the rest of the operator tree will be row mode.
    vectorDesc.setVectorOutput(retPair.right);

    vectorDesc.setProcessingMode(processingMode);

    LOG.info("Vector GROUP BY operator will use processing mode " + processingMode.name() +
        ", isVectorOutput " + vectorDesc.isVectorOutput());

    return true;
  }

  private boolean validateFileSinkOperator(FileSinkOperator op) {
   return true;
  }

  private boolean validateExprNodeDesc(List<ExprNodeDesc> descs) {
    return validateExprNodeDesc(descs, VectorExpressionDescriptor.Mode.PROJECTION);
  }

  private boolean validateExprNodeDesc(List<ExprNodeDesc> descs,
          VectorExpressionDescriptor.Mode mode) {
    for (ExprNodeDesc d : descs) {
      boolean ret = validateExprNodeDesc(d, mode);
      if (!ret) {
        return false;
      }
    }
    return true;
  }

  private Pair<Boolean,Boolean> validateAggregationDescs(List<AggregationDesc> descs,
      ProcessingMode processingMode, boolean hasKeys) {
    boolean outputIsPrimitive = true;
    for (AggregationDesc d : descs) {
      Pair<Boolean,Boolean>  retPair = validateAggregationDesc(d, processingMode, hasKeys);
      if (!retPair.left) {
        return retPair;
      }
      if (!retPair.right) {
        outputIsPrimitive = false;
      }
    }
    return new Pair<Boolean, Boolean>(true, outputIsPrimitive);
  }

  private boolean validateExprNodeDescRecursive(ExprNodeDesc desc, VectorExpressionDescriptor.Mode mode) {
    if (desc instanceof ExprNodeColumnDesc) {
      ExprNodeColumnDesc c = (ExprNodeColumnDesc) desc;
      // Currently, we do not support vectorized virtual columns (see HIVE-5570).
      if (VirtualColumn.VIRTUAL_COLUMN_NAMES.contains(c.getColumn())) {
        LOG.info("Cannot vectorize virtual column " + c.getColumn());
        return false;
      }
    }
    String typeName = desc.getTypeInfo().getTypeName();
    boolean ret = validateDataType(typeName, mode);
    if (!ret) {
      LOG.info("Cannot vectorize " + desc.toString() + " of type " + typeName);
      return false;
    }
    boolean isInExpression = false;
    if (desc instanceof ExprNodeGenericFuncDesc) {
      ExprNodeGenericFuncDesc d = (ExprNodeGenericFuncDesc) desc;
      boolean r = validateGenericUdf(d);
      if (!r) {
        LOG.info("Cannot vectorize UDF " + d);
        return false;
      }
      GenericUDF genericUDF = d.getGenericUDF();
      isInExpression = (genericUDF instanceof GenericUDFIn);
    }
    if (desc.getChildren() != null) {
      if (isInExpression
          && desc.getChildren().get(0).getTypeInfo().getCategory() == Category.STRUCT) {
        // Don't restrict child expressions for projection.
        // Always use loose FILTER mode.
        if (!validateStructInExpression(desc, VectorExpressionDescriptor.Mode.FILTER)) {
          return false;
        }
      } else {
        for (ExprNodeDesc d : desc.getChildren()) {
          // Don't restrict child expressions for projection.
          // Always use loose FILTER mode.
          if (!validateExprNodeDescRecursive(d, VectorExpressionDescriptor.Mode.FILTER)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean validateStructInExpression(ExprNodeDesc desc,
      VectorExpressionDescriptor.Mode mode) {
    for (ExprNodeDesc d : desc.getChildren()) {
      TypeInfo typeInfo = d.getTypeInfo();
      if (typeInfo.getCategory() != Category.STRUCT) {
        return false;
      }
      StructTypeInfo structTypeInfo = (StructTypeInfo) typeInfo;

      ArrayList<TypeInfo> fieldTypeInfos = structTypeInfo
          .getAllStructFieldTypeInfos();
      ArrayList<String> fieldNames = structTypeInfo.getAllStructFieldNames();
      final int fieldCount = fieldTypeInfos.size();
      for (int f = 0; f < fieldCount; f++) {
        TypeInfo fieldTypeInfo = fieldTypeInfos.get(f);
        Category category = fieldTypeInfo.getCategory();
        if (category != Category.PRIMITIVE) {
          LOG.info("Cannot vectorize struct field " + fieldNames.get(f)
              + " of type " + fieldTypeInfo.getTypeName());
          return false;
        }
        PrimitiveTypeInfo fieldPrimitiveTypeInfo = (PrimitiveTypeInfo) fieldTypeInfo;
        InConstantType inConstantType = VectorizationContext
            .getInConstantTypeFromPrimitiveCategory(fieldPrimitiveTypeInfo
                .getPrimitiveCategory());

        // For now, limit the data types we support for Vectorized Struct IN().
        if (inConstantType != InConstantType.INT_FAMILY
            && inConstantType != InConstantType.FLOAT_FAMILY
            && inConstantType != InConstantType.STRING_FAMILY) {
          LOG.info("Cannot vectorize struct field " + fieldNames.get(f)
              + " of type " + fieldTypeInfo.getTypeName());
          return false;
        }
      }
    }
    return true;
  }

  private boolean validateExprNodeDesc(ExprNodeDesc desc) {
    return validateExprNodeDesc(desc, VectorExpressionDescriptor.Mode.PROJECTION);
  }

  boolean validateExprNodeDesc(ExprNodeDesc desc, VectorExpressionDescriptor.Mode mode) {
    if (!validateExprNodeDescRecursive(desc, mode)) {
      return false;
    }
    try {
      VectorizationContext vc = new ValidatorVectorizationContext(hiveConf);
      if (vc.getVectorExpression(desc, mode) == null) {
        // TODO: this cannot happen - VectorizationContext throws in such cases.
        LOG.info("getVectorExpression returned null");
        return false;
      }
    } catch (Exception e) {
      if (e instanceof HiveException) {
        LOG.info(e.getMessage());
      } else {
        if (LOG.isDebugEnabled()) {
          // Show stack trace.
          LOG.debug("Failed to vectorize", e);
        } else {
          LOG.info("Failed to vectorize", e.getMessage());
        }
      }
      return false;
    }
    return true;
  }

  private boolean validateGenericUdf(ExprNodeGenericFuncDesc genericUDFExpr) {
    if (VectorizationContext.isCustomUDF(genericUDFExpr)) {
      return true;
    }
    GenericUDF genericUDF = genericUDFExpr.getGenericUDF();
    if (genericUDF instanceof GenericUDFBridge) {
      Class<? extends UDF> udf = ((GenericUDFBridge) genericUDF).getUdfClass();
      return supportedGenericUDFs.contains(udf);
    } else {
      return supportedGenericUDFs.contains(genericUDF.getClass());
    }
  }

  private boolean validateAggregationIsPrimitive(VectorAggregateExpression vectorAggrExpr) {
    ObjectInspector outputObjInspector = vectorAggrExpr.getOutputObjectInspector();
    return (outputObjInspector.getCategory() == ObjectInspector.Category.PRIMITIVE);
  }

  private Pair<Boolean,Boolean> validateAggregationDesc(AggregationDesc aggDesc, ProcessingMode processingMode,
      boolean hasKeys) {

    String udfName = aggDesc.getGenericUDAFName().toLowerCase();
    if (!supportedAggregationUdfs.contains(udfName)) {
      LOG.info("Cannot vectorize groupby aggregate expression: UDF " + udfName + " not supported");
      return new Pair<Boolean,Boolean>(false, false);
    }
    if (aggDesc.getParameters() != null && !validateExprNodeDesc(aggDesc.getParameters())) {
      LOG.info("Cannot vectorize groupby aggregate expression: UDF parameters not supported");
      return new Pair<Boolean,Boolean>(false, false);
    }

    // See if we can vectorize the aggregation.
    VectorizationContext vc = new ValidatorVectorizationContext(hiveConf);
    VectorAggregateExpression vectorAggrExpr;
    try {
        vectorAggrExpr = vc.getAggregatorExpression(aggDesc);
    } catch (Exception e) {
      // We should have already attempted to vectorize in validateAggregationDesc.
      if (LOG.isDebugEnabled()) {
        LOG.debug("Vectorization of aggreation should have succeeded ", e);
      }
      return new Pair<Boolean,Boolean>(false, false);
    }
    if (LOG.isDebugEnabled()) {
      LOG.debug("Aggregation " + aggDesc.getExprString() + " --> " +
          " vector expression " + vectorAggrExpr.toString());
    }

    boolean outputIsPrimitive = validateAggregationIsPrimitive(vectorAggrExpr);
    if (processingMode == ProcessingMode.MERGE_PARTIAL &&
        hasKeys &&
        !outputIsPrimitive) {
      LOG.info("Vectorized Reduce MergePartial GROUP BY keys can only handle aggregate outputs that are primitive types");
      return new Pair<Boolean,Boolean>(false, false);
    }

    return new Pair<Boolean,Boolean>(true, outputIsPrimitive);
  }

  public static boolean validateDataType(String type, VectorExpressionDescriptor.Mode mode) {
    type = type.toLowerCase();
    boolean result = supportedDataTypesPattern.matcher(type).matches();
    if (result && mode == VectorExpressionDescriptor.Mode.PROJECTION && type.equals("void")) {
      return false;
    }
    return result;
  }

  private VectorizationContext getVectorizationContext(String contextName,
      VectorTaskColumnInfo vectorTaskColumnInfo) {

    VectorizationContext vContext =
        new VectorizationContext(contextName, vectorTaskColumnInfo.allColumnNames, hiveConf);

    return vContext;
  }

  private void fixupParentChildOperators(Operator<? extends OperatorDesc> op,
          Operator<? extends OperatorDesc> vectorOp) {
    if (op.getParentOperators() != null) {
      vectorOp.setParentOperators(op.getParentOperators());
      for (Operator<? extends OperatorDesc> p : op.getParentOperators()) {
        p.replaceChild(op, vectorOp);
      }
    }
    if (op.getChildOperators() != null) {
      vectorOp.setChildOperators(op.getChildOperators());
      for (Operator<? extends OperatorDesc> c : op.getChildOperators()) {
        c.replaceParent(op, vectorOp);
      }
    }
  }

  private boolean isBigTableOnlyResults(MapJoinDesc desc) {
    Byte[] order = desc.getTagOrder();
    byte posBigTable = (byte) desc.getPosBigTable();
    Byte posSingleVectorMapJoinSmallTable = (order[0] == posBigTable ? order[1] : order[0]);

    int[] smallTableIndices;
    int smallTableIndicesSize;
    if (desc.getValueIndices() != null && desc.getValueIndices().get(posSingleVectorMapJoinSmallTable) != null) {
      smallTableIndices = desc.getValueIndices().get(posSingleVectorMapJoinSmallTable);
      LOG.info("Vectorizer isBigTableOnlyResults smallTableIndices " + Arrays.toString(smallTableIndices));
      smallTableIndicesSize = smallTableIndices.length;
    } else {
      smallTableIndices = null;
      LOG.info("Vectorizer isBigTableOnlyResults smallTableIndices EMPTY");
      smallTableIndicesSize = 0;
    }

    List<Integer> smallTableRetainList = desc.getRetainList().get(posSingleVectorMapJoinSmallTable);
    LOG.info("Vectorizer isBigTableOnlyResults smallTableRetainList " + smallTableRetainList);
    int smallTableRetainSize = smallTableRetainList.size();

    if (smallTableIndicesSize > 0) {
      // Small table indices has priority over retain.
      for (int i = 0; i < smallTableIndicesSize; i++) {
        if (smallTableIndices[i] < 0) {
          // Negative numbers indicate a column to be (deserialize) read from the small table's
          // LazyBinary value row.
          LOG.info("Vectorizer isBigTableOnlyResults smallTableIndices[i] < 0 returning false");
          return false;
        }
      }
    } else if (smallTableRetainSize > 0) {
      LOG.info("Vectorizer isBigTableOnlyResults smallTableRetainSize > 0 returning false");
      return false;
    }

    LOG.info("Vectorizer isBigTableOnlyResults returning true");
    return true;
  }

  Operator<? extends OperatorDesc> specializeMapJoinOperator(Operator<? extends OperatorDesc> op,
        VectorizationContext vContext, MapJoinDesc desc) throws HiveException {
    Operator<? extends OperatorDesc> vectorOp = null;
    Class<? extends Operator<?>> opClass = null;

    VectorMapJoinDesc.HashTableImplementationType hashTableImplementationType = HashTableImplementationType.NONE;
    VectorMapJoinDesc.HashTableKind hashTableKind = HashTableKind.NONE;
    VectorMapJoinDesc.HashTableKeyType hashTableKeyType = HashTableKeyType.NONE;

    if (HiveConf.getBoolVar(hiveConf,
              HiveConf.ConfVars.HIVE_VECTORIZATION_MAPJOIN_NATIVE_FAST_HASHTABLE_ENABLED)) {
      hashTableImplementationType = HashTableImplementationType.FAST;
    } else {
      // Restrict to using BytesBytesMultiHashMap via MapJoinBytesTableContainer or
      // HybridHashTableContainer.
      hashTableImplementationType = HashTableImplementationType.OPTIMIZED;
    }

    int joinType = desc.getConds()[0].getType();

    boolean isInnerBigOnly = false;
    if (joinType == JoinDesc.INNER_JOIN && isBigTableOnlyResults(desc)) {
      isInnerBigOnly = true;
    }

    // By default, we can always use the multi-key class.
    hashTableKeyType = HashTableKeyType.MULTI_KEY;

    if (!HiveConf.getBoolVar(hiveConf,
        HiveConf.ConfVars.HIVE_VECTORIZATION_MAPJOIN_NATIVE_MULTIKEY_ONLY_ENABLED)) {

      // Look for single column optimization.
      byte posBigTable = (byte) desc.getPosBigTable();
      Map<Byte, List<ExprNodeDesc>> keyExprs = desc.getKeys();
      List<ExprNodeDesc> bigTableKeyExprs = keyExprs.get(posBigTable);
      if (bigTableKeyExprs.size() == 1) {
        String typeName = bigTableKeyExprs.get(0).getTypeString();
        LOG.info("Vectorizer vectorizeOperator map join typeName " + typeName);
        if (typeName.equals("boolean")) {
          hashTableKeyType = HashTableKeyType.BOOLEAN;
        } else if (typeName.equals("tinyint")) {
          hashTableKeyType = HashTableKeyType.BYTE;
        } else if (typeName.equals("smallint")) {
          hashTableKeyType = HashTableKeyType.SHORT;
        } else if (typeName.equals("int")) {
          hashTableKeyType = HashTableKeyType.INT;
        } else if (typeName.equals("bigint") || typeName.equals("long")) {
          hashTableKeyType = HashTableKeyType.LONG;
        } else if (VectorizationContext.isStringFamily(typeName)) {
          hashTableKeyType = HashTableKeyType.STRING;
        }
      }
    }

    switch (joinType) {
    case JoinDesc.INNER_JOIN:
      if (!isInnerBigOnly) {
        hashTableKind = HashTableKind.HASH_MAP;
      } else {
        hashTableKind = HashTableKind.HASH_MULTISET;
      }
      break;
    case JoinDesc.LEFT_OUTER_JOIN:
    case JoinDesc.RIGHT_OUTER_JOIN:
      hashTableKind = HashTableKind.HASH_MAP;
      break;
    case JoinDesc.LEFT_SEMI_JOIN:
      hashTableKind = HashTableKind.HASH_SET;
      break;
    default:
      throw new HiveException("Unknown join type " + joinType);
    }

    LOG.info("Vectorizer vectorizeOperator map join hashTableKind " + hashTableKind.name() + " hashTableKeyType " + hashTableKeyType.name());

    switch (hashTableKeyType) {
    case BOOLEAN:
    case BYTE:
    case SHORT:
    case INT:
    case LONG:
      switch (joinType) {
      case JoinDesc.INNER_JOIN:
        if (!isInnerBigOnly) {
          opClass = VectorMapJoinInnerLongOperator.class;
        } else {
          opClass = VectorMapJoinInnerBigOnlyLongOperator.class;
        }
        break;
      case JoinDesc.LEFT_OUTER_JOIN:
      case JoinDesc.RIGHT_OUTER_JOIN:
        opClass = VectorMapJoinOuterLongOperator.class;
        break;
      case JoinDesc.LEFT_SEMI_JOIN:
        opClass = VectorMapJoinLeftSemiLongOperator.class;
        break;
      default:
        throw new HiveException("Unknown join type " + joinType);
      }
      break;
    case STRING:
      switch (joinType) {
      case JoinDesc.INNER_JOIN:
        if (!isInnerBigOnly) {
          opClass = VectorMapJoinInnerStringOperator.class;
        } else {
          opClass = VectorMapJoinInnerBigOnlyStringOperator.class;
        }
        break;
      case JoinDesc.LEFT_OUTER_JOIN:
      case JoinDesc.RIGHT_OUTER_JOIN:
        opClass = VectorMapJoinOuterStringOperator.class;
        break;
      case JoinDesc.LEFT_SEMI_JOIN:
        opClass = VectorMapJoinLeftSemiStringOperator.class;
        break;
      default:
        throw new HiveException("Unknown join type " + joinType);
      }
      break;
    case MULTI_KEY:
      switch (joinType) {
      case JoinDesc.INNER_JOIN:
        if (!isInnerBigOnly) {
          opClass = VectorMapJoinInnerMultiKeyOperator.class;
        } else {
          opClass = VectorMapJoinInnerBigOnlyMultiKeyOperator.class;
        }
        break;
      case JoinDesc.LEFT_OUTER_JOIN:
      case JoinDesc.RIGHT_OUTER_JOIN:
        opClass = VectorMapJoinOuterMultiKeyOperator.class;
        break;
      case JoinDesc.LEFT_SEMI_JOIN:
        opClass = VectorMapJoinLeftSemiMultiKeyOperator.class;
        break;
      default:
        throw new HiveException("Unknown join type " + joinType);
      }
      break;
    }

    vectorOp = OperatorFactory.getVectorOperator(
        opClass, op.getCompilationOpContext(), op.getConf(), vContext);
    LOG.info("Vectorizer vectorizeOperator map join class " + vectorOp.getClass().getSimpleName());

    boolean minMaxEnabled = HiveConf.getBoolVar(hiveConf,
        HiveConf.ConfVars.HIVE_VECTORIZATION_MAPJOIN_NATIVE_MINMAX_ENABLED);

    VectorMapJoinDesc vectorDesc = desc.getVectorDesc();
    vectorDesc.setHashTableImplementationType(hashTableImplementationType);
    vectorDesc.setHashTableKind(hashTableKind);
    vectorDesc.setHashTableKeyType(hashTableKeyType);
    vectorDesc.setMinMaxEnabled(minMaxEnabled);
    return vectorOp;
  }

  private boolean onExpressionHasNullSafes(MapJoinDesc desc) {
    boolean[] nullSafes = desc.getNullSafes();
    if (nullSafes == null) {
	return false;
    }
    for (boolean nullSafe : nullSafes) {
      if (nullSafe) {
        return true;
      }
    }
    return false;
  }

  private boolean canSpecializeMapJoin(Operator<? extends OperatorDesc> op, MapJoinDesc desc,
      boolean isTez) {

    boolean specialize = false;

    if (op instanceof MapJoinOperator &&
        HiveConf.getBoolVar(hiveConf,
            HiveConf.ConfVars.HIVE_VECTORIZATION_MAPJOIN_NATIVE_ENABLED)) {

      // Currently, only under Tez and non-N-way joins.
      if (isTez && desc.getConds().length == 1 && !onExpressionHasNullSafes(desc)) {

        // Ok, all basic restrictions satisfied so far...
        specialize = true;

        if (!HiveConf.getBoolVar(hiveConf,
            HiveConf.ConfVars.HIVE_VECTORIZATION_MAPJOIN_NATIVE_FAST_HASHTABLE_ENABLED)) {

          // We are using the optimized hash table we have further
          // restrictions (using optimized and key type).

          if (!HiveConf.getBoolVar(hiveConf,
              HiveConf.ConfVars.HIVEMAPJOINUSEOPTIMIZEDTABLE)) {
            specialize = false;
          } else {
            byte posBigTable = (byte) desc.getPosBigTable();
            Map<Byte, List<ExprNodeDesc>> keyExprs = desc.getKeys();
            List<ExprNodeDesc> bigTableKeyExprs = keyExprs.get(posBigTable);
            for (ExprNodeDesc exprNodeDesc : bigTableKeyExprs) {
              String typeName = exprNodeDesc.getTypeString();
              if (!MapJoinKey.isSupportedField(typeName)) {
                specialize = false;
                break;
              }
            }
          }
        } else {

          // With the fast hash table implementation, we currently do not support
          // Hybrid Grace Hash Join.

          if (desc.isHybridHashJoin()) {
            specialize = false;
          }
        }
      }
    }
    return specialize;
  }

  private Operator<? extends OperatorDesc> specializeReduceSinkOperator(
      Operator<? extends OperatorDesc> op, VectorizationContext vContext, ReduceSinkDesc desc,
      VectorReduceSinkInfo vectorReduceSinkInfo) throws HiveException {

    Operator<? extends OperatorDesc> vectorOp = null;
    Class<? extends Operator<?>> opClass = null;

    Type[] reduceSinkKeyColumnVectorTypes = vectorReduceSinkInfo.getReduceSinkKeyColumnVectorTypes();

    // By default, we can always use the multi-key class.
    VectorReduceSinkDesc.ReduceSinkKeyType reduceSinkKeyType = VectorReduceSinkDesc.ReduceSinkKeyType.MULTI_KEY;

    // Look for single column optimization.
    if (reduceSinkKeyColumnVectorTypes.length == 1) {
      LOG.info("Vectorizer vectorizeOperator groupby typeName " + vectorReduceSinkInfo.getReduceSinkKeyTypeInfos()[0]);
      Type columnVectorType = reduceSinkKeyColumnVectorTypes[0];
      switch (columnVectorType) {
      case LONG:
        {
          PrimitiveCategory primitiveCategory =
              ((PrimitiveTypeInfo) vectorReduceSinkInfo.getReduceSinkKeyTypeInfos()[0]).getPrimitiveCategory();
          switch (primitiveCategory) {
          case BOOLEAN:
          case BYTE:
          case SHORT:
          case INT:
          case LONG:
            reduceSinkKeyType = VectorReduceSinkDesc.ReduceSinkKeyType.LONG;
            break;
          default:
            // Other integer types not supported yet.
            break;
          }
        }
        break;
      case BYTES:
        reduceSinkKeyType = VectorReduceSinkDesc.ReduceSinkKeyType.STRING;
      default:
        // Stay with multi-key.
        break;
      }
    }

    switch (reduceSinkKeyType) {
    case LONG:
      opClass = VectorReduceSinkLongOperator.class;
      break;
    case STRING:
      opClass = VectorReduceSinkStringOperator.class;
      break;
    case MULTI_KEY:
      opClass = VectorReduceSinkMultiKeyOperator.class;
      break;
    default:
      throw new HiveException("Unknown reduce sink key type " + reduceSinkKeyType);
    }

    VectorReduceSinkDesc vectorDesc = new VectorReduceSinkDesc();
    desc.setVectorDesc(vectorDesc);
    vectorDesc.setReduceSinkKeyType(reduceSinkKeyType);
    vectorDesc.setVectorReduceSinkInfo(vectorReduceSinkInfo);

    vectorOp = OperatorFactory.getVectorOperator(
        opClass, op.getCompilationOpContext(), op.getConf(), vContext);
    LOG.info("Vectorizer vectorizeOperator reduce sink class " + vectorOp.getClass().getSimpleName());

    return vectorOp;
  }

  private boolean canSpecializeReduceSink(ReduceSinkDesc desc,
      boolean isTez, VectorizationContext vContext,
      VectorReduceSinkInfo vectorReduceSinkInfo) throws HiveException {

    if (!HiveConf.getBoolVar(hiveConf,
        HiveConf.ConfVars.HIVE_VECTORIZATION_REDUCESINK_NEW_ENABLED)) {
      return false;
    }

    // Many restrictions.

    if (!isTez) {
      return false;
    }

    if (desc.getWriteType() == AcidUtils.Operation.UPDATE ||
        desc.getWriteType() == AcidUtils.Operation.DELETE) {
      return false;
    }

    if (desc.getBucketCols() != null && !desc.getBucketCols().isEmpty()) {
      return false;
    }

    boolean useUniformHash = desc.getReducerTraits().contains(UNIFORM);
    if (!useUniformHash) {
      return false;
    }

    if (desc.getTopN() >= 0) {
      return false;
    }

    if (desc.getDistinctColumnIndices().size() > 0) {
      return false;
    }

    TableDesc keyTableDesc = desc.getKeySerializeInfo();
    Class<? extends Deserializer> keySerializerClass = keyTableDesc.getDeserializerClass();
    if (keySerializerClass != org.apache.hadoop.hive.serde2.binarysortable.BinarySortableSerDe.class) {
      return false;
    }

    TableDesc valueTableDesc = desc.getValueSerializeInfo();
    Class<? extends Deserializer> valueDeserializerClass = valueTableDesc.getDeserializerClass();
    if (valueDeserializerClass != org.apache.hadoop.hive.serde2.lazybinary.LazyBinarySerDe.class) {
      return false;
    }

    // We are doing work here we'd normally do in VectorGroupByCommonOperator's constructor.
    // So if we later decide not to specialize, we'll just waste any scratch columns allocated...

    List<ExprNodeDesc> keysDescs = desc.getKeyCols();
    VectorExpression[] allKeyExpressions = vContext.getVectorExpressions(keysDescs);

    // Since a key expression can be a calculation and the key will go into a scratch column,
    // we need the mapping and type information.
    int[] reduceSinkKeyColumnMap = new int[allKeyExpressions.length];
    TypeInfo[] reduceSinkKeyTypeInfos = new TypeInfo[allKeyExpressions.length];
    Type[] reduceSinkKeyColumnVectorTypes = new Type[allKeyExpressions.length];
    ArrayList<VectorExpression> groupByKeyExpressionsList = new ArrayList<VectorExpression>();
    VectorExpression[] reduceSinkKeyExpressions;
    for (int i = 0; i < reduceSinkKeyColumnMap.length; i++) {
      VectorExpression ve = allKeyExpressions[i];
      reduceSinkKeyColumnMap[i] = ve.getOutputColumn();
      reduceSinkKeyTypeInfos[i] = keysDescs.get(i).getTypeInfo();
      reduceSinkKeyColumnVectorTypes[i] =
          VectorizationContext.getColumnVectorTypeFromTypeInfo(reduceSinkKeyTypeInfos[i]);
      if (!IdentityExpression.isColumnOnly(ve)) {
        groupByKeyExpressionsList.add(ve);
      }
    }
    if (groupByKeyExpressionsList.size() == 0) {
      reduceSinkKeyExpressions = null;
    } else {
      reduceSinkKeyExpressions = groupByKeyExpressionsList.toArray(new VectorExpression[0]);
    }

    ArrayList<ExprNodeDesc> valueDescs = desc.getValueCols();
    VectorExpression[] allValueExpressions = vContext.getVectorExpressions(valueDescs);

    int[] reduceSinkValueColumnMap = new int[valueDescs.size()];
    TypeInfo[] reduceSinkValueTypeInfos = new TypeInfo[valueDescs.size()];
    Type[] reduceSinkValueColumnVectorTypes = new Type[valueDescs.size()];
    ArrayList<VectorExpression> reduceSinkValueExpressionsList = new ArrayList<VectorExpression>();
    VectorExpression[] reduceSinkValueExpressions;
    for (int i = 0; i < valueDescs.size(); ++i) {
      VectorExpression ve = allValueExpressions[i];
      reduceSinkValueColumnMap[i] = ve.getOutputColumn();
      reduceSinkValueTypeInfos[i] = valueDescs.get(i).getTypeInfo();
      reduceSinkValueColumnVectorTypes[i] =
          VectorizationContext.getColumnVectorTypeFromTypeInfo(reduceSinkValueTypeInfos[i]);
      if (!IdentityExpression.isColumnOnly(ve)) {
        reduceSinkValueExpressionsList.add(ve);
      }
    }
    if (reduceSinkValueExpressionsList.size() == 0) {
      reduceSinkValueExpressions = null;
    } else {
      reduceSinkValueExpressions = reduceSinkValueExpressionsList.toArray(new VectorExpression[0]);
    }

    vectorReduceSinkInfo.setReduceSinkKeyColumnMap(reduceSinkKeyColumnMap);
    vectorReduceSinkInfo.setReduceSinkKeyTypeInfos(reduceSinkKeyTypeInfos);
    vectorReduceSinkInfo.setReduceSinkKeyColumnVectorTypes(reduceSinkKeyColumnVectorTypes);
    vectorReduceSinkInfo.setReduceSinkKeyExpressions(reduceSinkKeyExpressions);

    vectorReduceSinkInfo.setReduceSinkValueColumnMap(reduceSinkValueColumnMap);
    vectorReduceSinkInfo.setReduceSinkValueTypeInfos(reduceSinkValueTypeInfos);
    vectorReduceSinkInfo.setReduceSinkValueColumnVectorTypes(reduceSinkValueColumnVectorTypes);
    vectorReduceSinkInfo.setReduceSinkValueExpressions(reduceSinkValueExpressions);

    return true;
  }

  Operator<? extends OperatorDesc> vectorizeOperator(Operator<? extends OperatorDesc> op,
      VectorizationContext vContext, boolean isTez) throws HiveException {
    Operator<? extends OperatorDesc> vectorOp = null;

    switch (op.getType()) {
      case MAPJOIN:
        {
          MapJoinDesc desc = (MapJoinDesc) op.getConf();
          boolean specialize = canSpecializeMapJoin(op, desc, isTez || isSpark);

          if (!specialize) {

            Class<? extends Operator<?>> opClass = null;
            if (op instanceof MapJoinOperator) {

              // *NON-NATIVE* vector map differences for LEFT OUTER JOIN and Filtered...

              List<ExprNodeDesc> bigTableFilters = desc.getFilters().get((byte) desc.getPosBigTable());
              boolean isOuterAndFiltered = (!desc.isNoOuterJoin() && bigTableFilters.size() > 0);
              if (!isOuterAndFiltered) {
                opClass = VectorMapJoinOperator.class;
              } else {
                opClass = VectorMapJoinOuterFilteredOperator.class;
              }
            } else if (op instanceof SMBMapJoinOperator) {
              opClass = VectorSMBMapJoinOperator.class;
            }

            vectorOp = OperatorFactory.getVectorOperator(
                opClass, op.getCompilationOpContext(), op.getConf(), vContext);

          } else {

            // TEMPORARY Until Native Vector Map Join with Hybrid passes tests...
            // HiveConf.setBoolVar(physicalContext.getConf(),
            //    HiveConf.ConfVars.HIVEUSEHYBRIDGRACEHASHJOIN, false);

            vectorOp = specializeMapJoinOperator(op, vContext, desc);
          }
        }
        break;

      case REDUCESINK:
        {
          VectorReduceSinkInfo vectorReduceSinkInfo = new VectorReduceSinkInfo();
          ReduceSinkDesc desc = (ReduceSinkDesc) op.getConf();
          boolean specialize = canSpecializeReduceSink(desc, isTez, vContext, vectorReduceSinkInfo);

          if (!specialize) {

            vectorOp = OperatorFactory.getVectorOperator(
                op.getCompilationOpContext(), op.getConf(), vContext);

          } else {

            vectorOp = specializeReduceSinkOperator(op, vContext, desc, vectorReduceSinkInfo);

          }
        }
        break;
      case GROUPBY:
      case FILTER:
      case SELECT:
      case FILESINK:
      case LIMIT:
      case EXTRACT:
      case EVENT:
      case HASHTABLESINK:
        vectorOp = OperatorFactory.getVectorOperator(
            op.getCompilationOpContext(), op.getConf(), vContext);
        break;
      default:
        vectorOp = op;
        break;
    }

    LOG.debug("vectorizeOperator " + (vectorOp == null ? "NULL" : vectorOp.getClass().getName()));
    LOG.debug("vectorizeOperator " + (vectorOp == null || vectorOp.getConf() == null ? "NULL" : vectorOp.getConf().getClass().getName()));

    if (vectorOp != op) {
      fixupParentChildOperators(op, vectorOp);
      ((AbstractOperatorDesc) vectorOp.getConf()).setVectorMode(true);
    }
    return vectorOp;
  }

  private boolean isVirtualColumn(ColumnInfo column) {

    // Not using method column.getIsVirtualCol() because partitioning columns are also
    // treated as virtual columns in ColumnInfo.
    if (VirtualColumn.VIRTUAL_COLUMN_NAMES.contains(column.getInternalName())) {
        return true;
    }
    return false;
  }

  public void debugDisplayAllMaps(BaseWork work) {

    VectorizedRowBatchCtx vectorizedRowBatchCtx = work.getVectorizedRowBatchCtx();

    String[] allColumnNames = vectorizedRowBatchCtx.getRowColumnNames();
    Object columnTypeInfos = vectorizedRowBatchCtx.getRowColumnTypeInfos();
    int partitionColumnCount = vectorizedRowBatchCtx.getPartitionColumnCount();
    String[] scratchColumnTypeNames =vectorizedRowBatchCtx.getScratchColumnTypeNames();

    LOG.debug("debugDisplayAllMaps allColumnNames " + Arrays.toString(allColumnNames));
    LOG.debug("debugDisplayAllMaps columnTypeInfos " + Arrays.deepToString((Object[]) columnTypeInfos));
    LOG.debug("debugDisplayAllMaps partitionColumnCount " + partitionColumnCount);
    LOG.debug("debugDisplayAllMaps scratchColumnTypeNames " + Arrays.toString(scratchColumnTypeNames));
  }
}

