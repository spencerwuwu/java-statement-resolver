// https://searchcode.com/api/result/75751109/

/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.thriftfs.jobtracker.api;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Counters for map tasks only, reduce tasks only, and job-scoped counters
 */
public class ThriftJobCounterRollups implements org.apache.thrift.TBase<ThriftJobCounterRollups, ThriftJobCounterRollups._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftJobCounterRollups");

  private static final org.apache.thrift.protocol.TField MAP_COUNTERS_FIELD_DESC = new org.apache.thrift.protocol.TField("mapCounters", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField REDUCE_COUNTERS_FIELD_DESC = new org.apache.thrift.protocol.TField("reduceCounters", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField JOB_COUNTERS_FIELD_DESC = new org.apache.thrift.protocol.TField("jobCounters", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ThriftJobCounterRollupsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ThriftJobCounterRollupsTupleSchemeFactory());
  }

  public ThriftGroupList mapCounters; // required
  public ThriftGroupList reduceCounters; // required
  public ThriftGroupList jobCounters; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MAP_COUNTERS((short)1, "mapCounters"),
    REDUCE_COUNTERS((short)2, "reduceCounters"),
    JOB_COUNTERS((short)3, "jobCounters");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // MAP_COUNTERS
          return MAP_COUNTERS;
        case 2: // REDUCE_COUNTERS
          return REDUCE_COUNTERS;
        case 3: // JOB_COUNTERS
          return JOB_COUNTERS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MAP_COUNTERS, new org.apache.thrift.meta_data.FieldMetaData("mapCounters", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ThriftGroupList.class)));
    tmpMap.put(_Fields.REDUCE_COUNTERS, new org.apache.thrift.meta_data.FieldMetaData("reduceCounters", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ThriftGroupList.class)));
    tmpMap.put(_Fields.JOB_COUNTERS, new org.apache.thrift.meta_data.FieldMetaData("jobCounters", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ThriftGroupList.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftJobCounterRollups.class, metaDataMap);
  }

  public ThriftJobCounterRollups() {
  }

  public ThriftJobCounterRollups(
    ThriftGroupList mapCounters,
    ThriftGroupList reduceCounters,
    ThriftGroupList jobCounters)
  {
    this();
    this.mapCounters = mapCounters;
    this.reduceCounters = reduceCounters;
    this.jobCounters = jobCounters;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftJobCounterRollups(ThriftJobCounterRollups other) {
    if (other.isSetMapCounters()) {
      this.mapCounters = new ThriftGroupList(other.mapCounters);
    }
    if (other.isSetReduceCounters()) {
      this.reduceCounters = new ThriftGroupList(other.reduceCounters);
    }
    if (other.isSetJobCounters()) {
      this.jobCounters = new ThriftGroupList(other.jobCounters);
    }
  }

  public ThriftJobCounterRollups deepCopy() {
    return new ThriftJobCounterRollups(this);
  }

  @Override
  public void clear() {
    this.mapCounters = null;
    this.reduceCounters = null;
    this.jobCounters = null;
  }

  public ThriftGroupList getMapCounters() {
    return this.mapCounters;
  }

  public ThriftJobCounterRollups setMapCounters(ThriftGroupList mapCounters) {
    this.mapCounters = mapCounters;
    return this;
  }

  public void unsetMapCounters() {
    this.mapCounters = null;
  }

  /** Returns true if field mapCounters is set (has been assigned a value) and false otherwise */
  public boolean isSetMapCounters() {
    return this.mapCounters != null;
  }

  public void setMapCountersIsSet(boolean value) {
    if (!value) {
      this.mapCounters = null;
    }
  }

  public ThriftGroupList getReduceCounters() {
    return this.reduceCounters;
  }

  public ThriftJobCounterRollups setReduceCounters(ThriftGroupList reduceCounters) {
    this.reduceCounters = reduceCounters;
    return this;
  }

  public void unsetReduceCounters() {
    this.reduceCounters = null;
  }

  /** Returns true if field reduceCounters is set (has been assigned a value) and false otherwise */
  public boolean isSetReduceCounters() {
    return this.reduceCounters != null;
  }

  public void setReduceCountersIsSet(boolean value) {
    if (!value) {
      this.reduceCounters = null;
    }
  }

  public ThriftGroupList getJobCounters() {
    return this.jobCounters;
  }

  public ThriftJobCounterRollups setJobCounters(ThriftGroupList jobCounters) {
    this.jobCounters = jobCounters;
    return this;
  }

  public void unsetJobCounters() {
    this.jobCounters = null;
  }

  /** Returns true if field jobCounters is set (has been assigned a value) and false otherwise */
  public boolean isSetJobCounters() {
    return this.jobCounters != null;
  }

  public void setJobCountersIsSet(boolean value) {
    if (!value) {
      this.jobCounters = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case MAP_COUNTERS:
      if (value == null) {
        unsetMapCounters();
      } else {
        setMapCounters((ThriftGroupList)value);
      }
      break;

    case REDUCE_COUNTERS:
      if (value == null) {
        unsetReduceCounters();
      } else {
        setReduceCounters((ThriftGroupList)value);
      }
      break;

    case JOB_COUNTERS:
      if (value == null) {
        unsetJobCounters();
      } else {
        setJobCounters((ThriftGroupList)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case MAP_COUNTERS:
      return getMapCounters();

    case REDUCE_COUNTERS:
      return getReduceCounters();

    case JOB_COUNTERS:
      return getJobCounters();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case MAP_COUNTERS:
      return isSetMapCounters();
    case REDUCE_COUNTERS:
      return isSetReduceCounters();
    case JOB_COUNTERS:
      return isSetJobCounters();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftJobCounterRollups)
      return this.equals((ThriftJobCounterRollups)that);
    return false;
  }

  public boolean equals(ThriftJobCounterRollups that) {
    if (that == null)
      return false;

    boolean this_present_mapCounters = true && this.isSetMapCounters();
    boolean that_present_mapCounters = true && that.isSetMapCounters();
    if (this_present_mapCounters || that_present_mapCounters) {
      if (!(this_present_mapCounters && that_present_mapCounters))
        return false;
      if (!this.mapCounters.equals(that.mapCounters))
        return false;
    }

    boolean this_present_reduceCounters = true && this.isSetReduceCounters();
    boolean that_present_reduceCounters = true && that.isSetReduceCounters();
    if (this_present_reduceCounters || that_present_reduceCounters) {
      if (!(this_present_reduceCounters && that_present_reduceCounters))
        return false;
      if (!this.reduceCounters.equals(that.reduceCounters))
        return false;
    }

    boolean this_present_jobCounters = true && this.isSetJobCounters();
    boolean that_present_jobCounters = true && that.isSetJobCounters();
    if (this_present_jobCounters || that_present_jobCounters) {
      if (!(this_present_jobCounters && that_present_jobCounters))
        return false;
      if (!this.jobCounters.equals(that.jobCounters))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(ThriftJobCounterRollups other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ThriftJobCounterRollups typedOther = (ThriftJobCounterRollups)other;

    lastComparison = Boolean.valueOf(isSetMapCounters()).compareTo(typedOther.isSetMapCounters());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMapCounters()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mapCounters, typedOther.mapCounters);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetReduceCounters()).compareTo(typedOther.isSetReduceCounters());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReduceCounters()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reduceCounters, typedOther.reduceCounters);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetJobCounters()).compareTo(typedOther.isSetJobCounters());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJobCounters()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jobCounters, typedOther.jobCounters);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftJobCounterRollups(");
    boolean first = true;

    sb.append("mapCounters:");
    if (this.mapCounters == null) {
      sb.append("null");
    } else {
      sb.append(this.mapCounters);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("reduceCounters:");
    if (this.reduceCounters == null) {
      sb.append("null");
    } else {
      sb.append(this.reduceCounters);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("jobCounters:");
    if (this.jobCounters == null) {
      sb.append("null");
    } else {
      sb.append(this.jobCounters);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (mapCounters != null) {
      mapCounters.validate();
    }
    if (reduceCounters != null) {
      reduceCounters.validate();
    }
    if (jobCounters != null) {
      jobCounters.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ThriftJobCounterRollupsStandardSchemeFactory implements SchemeFactory {
    public ThriftJobCounterRollupsStandardScheme getScheme() {
      return new ThriftJobCounterRollupsStandardScheme();
    }
  }

  private static class ThriftJobCounterRollupsStandardScheme extends StandardScheme<ThriftJobCounterRollups> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ThriftJobCounterRollups struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MAP_COUNTERS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.mapCounters = new ThriftGroupList();
              struct.mapCounters.read(iprot);
              struct.setMapCountersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // REDUCE_COUNTERS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.reduceCounters = new ThriftGroupList();
              struct.reduceCounters.read(iprot);
              struct.setReduceCountersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // JOB_COUNTERS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.jobCounters = new ThriftGroupList();
              struct.jobCounters.read(iprot);
              struct.setJobCountersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ThriftJobCounterRollups struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.mapCounters != null) {
        oprot.writeFieldBegin(MAP_COUNTERS_FIELD_DESC);
        struct.mapCounters.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.reduceCounters != null) {
        oprot.writeFieldBegin(REDUCE_COUNTERS_FIELD_DESC);
        struct.reduceCounters.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.jobCounters != null) {
        oprot.writeFieldBegin(JOB_COUNTERS_FIELD_DESC);
        struct.jobCounters.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ThriftJobCounterRollupsTupleSchemeFactory implements SchemeFactory {
    public ThriftJobCounterRollupsTupleScheme getScheme() {
      return new ThriftJobCounterRollupsTupleScheme();
    }
  }

  private static class ThriftJobCounterRollupsTupleScheme extends TupleScheme<ThriftJobCounterRollups> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ThriftJobCounterRollups struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetMapCounters()) {
        optionals.set(0);
      }
      if (struct.isSetReduceCounters()) {
        optionals.set(1);
      }
      if (struct.isSetJobCounters()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetMapCounters()) {
        struct.mapCounters.write(oprot);
      }
      if (struct.isSetReduceCounters()) {
        struct.reduceCounters.write(oprot);
      }
      if (struct.isSetJobCounters()) {
        struct.jobCounters.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ThriftJobCounterRollups struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.mapCounters = new ThriftGroupList();
        struct.mapCounters.read(iprot);
        struct.setMapCountersIsSet(true);
      }
      if (incoming.get(1)) {
        struct.reduceCounters = new ThriftGroupList();
        struct.reduceCounters.read(iprot);
        struct.setReduceCountersIsSet(true);
      }
      if (incoming.get(2)) {
        struct.jobCounters = new ThriftGroupList();
        struct.jobCounters.read(iprot);
        struct.setJobCountersIsSet(true);
      }
    }
  }

}


