// https://searchcode.com/api/result/16718689/

/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.evernote.edam.type;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.Arrays;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

/**
 * A structure that wraps a map of name/value pairs whose values are not
 * always present in the structure in order to reduce space when obtaining
 * batches of entities that contain the map.
 * 
 * When the server provides the client with a LazyMap, it will fill in either
 * the keysOnly field or the fullMap field, but never both, based on the API
 * and parameters.
 * 
 * When a client provides a LazyMap to the server as part of an update to
 * an object, the server will only update the LazyMap if the fullMap field is
 * set. If the fullMap field is not set, the server will not make any changes
 * to the map.
 * 
 * Check the API documentation of the individual calls involving the LazyMap
 * for full details including the constraints of the names and values of the
 * map.
 * 
 * <dl>
 * <dt>keysOnly</dt>
 *   <dd>The set of keys for the map.  This field is ignored by the
 *       server when set.
 *   </dd>
 * 
 * <dt>fullMap</dt>
 *   <dd>The complete map, including all keys and values.
 *   </dd>
 * </dl>
 */
public class LazyMap implements TBase<LazyMap, LazyMap._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("LazyMap");

  private static final TField KEYS_ONLY_FIELD_DESC = new TField("keysOnly", TType.SET, (short)1);
  private static final TField FULL_MAP_FIELD_DESC = new TField("fullMap", TType.MAP, (short)2);

  private Set<String> keysOnly;
  private Map<String,String> fullMap;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    KEYS_ONLY((short)1, "keysOnly"),
    FULL_MAP((short)2, "fullMap");

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
        case 1: // KEYS_ONLY
          return KEYS_ONLY;
        case 2: // FULL_MAP
          return FULL_MAP;
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

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.KEYS_ONLY, new FieldMetaData("keysOnly", TFieldRequirementType.OPTIONAL, 
        new SetMetaData(TType.SET, 
            new FieldValueMetaData(TType.STRING))));
    tmpMap.put(_Fields.FULL_MAP, new FieldMetaData("fullMap", TFieldRequirementType.OPTIONAL, 
        new MapMetaData(TType.MAP, 
            new FieldValueMetaData(TType.STRING), 
            new FieldValueMetaData(TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(LazyMap.class, metaDataMap);
  }

  public LazyMap() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LazyMap(LazyMap other) {
    if (other.isSetKeysOnly()) {
      Set<String> __this__keysOnly = new HashSet<String>();
      for (String other_element : other.keysOnly) {
        __this__keysOnly.add(other_element);
      }
      this.keysOnly = __this__keysOnly;
    }
    if (other.isSetFullMap()) {
      Map<String,String> __this__fullMap = new HashMap<String,String>();
      for (Map.Entry<String, String> other_element : other.fullMap.entrySet()) {

        String other_element_key = other_element.getKey();
        String other_element_value = other_element.getValue();

        String __this__fullMap_copy_key = other_element_key;

        String __this__fullMap_copy_value = other_element_value;

        __this__fullMap.put(__this__fullMap_copy_key, __this__fullMap_copy_value);
      }
      this.fullMap = __this__fullMap;
    }
  }

  public LazyMap deepCopy() {
    return new LazyMap(this);
  }

  public void clear() {
    this.keysOnly = null;
    this.fullMap = null;
  }

  public int getKeysOnlySize() {
    return (this.keysOnly == null) ? 0 : this.keysOnly.size();
  }

  public java.util.Iterator<String> getKeysOnlyIterator() {
    return (this.keysOnly == null) ? null : this.keysOnly.iterator();
  }

  public void addToKeysOnly(String elem) {
    if (this.keysOnly == null) {
      this.keysOnly = new HashSet<String>();
    }
    this.keysOnly.add(elem);
  }

  public Set<String> getKeysOnly() {
    return this.keysOnly;
  }

  public void setKeysOnly(Set<String> keysOnly) {
    this.keysOnly = keysOnly;
  }

  public void unsetKeysOnly() {
    this.keysOnly = null;
  }

  /** Returns true if field keysOnly is set (has been asigned a value) and false otherwise */
  public boolean isSetKeysOnly() {
    return this.keysOnly != null;
  }

  public void setKeysOnlyIsSet(boolean value) {
    if (!value) {
      this.keysOnly = null;
    }
  }

  public int getFullMapSize() {
    return (this.fullMap == null) ? 0 : this.fullMap.size();
  }

  public void putToFullMap(String key, String val) {
    if (this.fullMap == null) {
      this.fullMap = new HashMap<String,String>();
    }
    this.fullMap.put(key, val);
  }

  public Map<String,String> getFullMap() {
    return this.fullMap;
  }

  public void setFullMap(Map<String,String> fullMap) {
    this.fullMap = fullMap;
  }

  public void unsetFullMap() {
    this.fullMap = null;
  }

  /** Returns true if field fullMap is set (has been asigned a value) and false otherwise */
  public boolean isSetFullMap() {
    return this.fullMap != null;
  }

  public void setFullMapIsSet(boolean value) {
    if (!value) {
      this.fullMap = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case KEYS_ONLY:
      if (value == null) {
        unsetKeysOnly();
      } else {
        setKeysOnly((Set<String>)value);
      }
      break;

    case FULL_MAP:
      if (value == null) {
        unsetFullMap();
      } else {
        setFullMap((Map<String,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case KEYS_ONLY:
      return getKeysOnly();

    case FULL_MAP:
      return getFullMap();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case KEYS_ONLY:
      return isSetKeysOnly();
    case FULL_MAP:
      return isSetFullMap();
    }
    throw new IllegalStateException();
  }

  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LazyMap)
      return this.equals((LazyMap)that);
    return false;
  }

  public boolean equals(LazyMap that) {
    if (that == null)
      return false;

    boolean this_present_keysOnly = true && this.isSetKeysOnly();
    boolean that_present_keysOnly = true && that.isSetKeysOnly();
    if (this_present_keysOnly || that_present_keysOnly) {
      if (!(this_present_keysOnly && that_present_keysOnly))
        return false;
      if (!this.keysOnly.equals(that.keysOnly))
        return false;
    }

    boolean this_present_fullMap = true && this.isSetFullMap();
    boolean that_present_fullMap = true && that.isSetFullMap();
    if (this_present_fullMap || that_present_fullMap) {
      if (!(this_present_fullMap && that_present_fullMap))
        return false;
      if (!this.fullMap.equals(that.fullMap))
        return false;
    }

    return true;
  }

  public int hashCode() {
    return 0;
  }

  public int compareTo(LazyMap other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    LazyMap typedOther = (LazyMap)other;

    lastComparison = Boolean.valueOf(isSetKeysOnly()).compareTo(typedOther.isSetKeysOnly());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKeysOnly()) {      lastComparison = TBaseHelper.compareTo(this.keysOnly, typedOther.keysOnly);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFullMap()).compareTo(typedOther.isSetFullMap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFullMap()) {      lastComparison = TBaseHelper.compareTo(this.fullMap, typedOther.fullMap);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // KEYS_ONLY
          if (field.type == TType.SET) {
            {
              TSet _set8 = iprot.readSetBegin();
              this.keysOnly = new HashSet<String>(2*_set8.size);
              for (int _i9 = 0; _i9 < _set8.size; ++_i9)
              {
                String _elem10;
                _elem10 = iprot.readString();
                this.keysOnly.add(_elem10);
              }
              iprot.readSetEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // FULL_MAP
          if (field.type == TType.MAP) {
            {
              TMap _map11 = iprot.readMapBegin();
              this.fullMap = new HashMap<String,String>(2*_map11.size);
              for (int _i12 = 0; _i12 < _map11.size; ++_i12)
              {
                String _key13;
                String _val14;
                _key13 = iprot.readString();
                _val14 = iprot.readString();
                this.fullMap.put(_key13, _val14);
              }
              iprot.readMapEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.keysOnly != null) {
      if (isSetKeysOnly()) {
        oprot.writeFieldBegin(KEYS_ONLY_FIELD_DESC);
        {
          oprot.writeSetBegin(new TSet(TType.STRING, this.keysOnly.size()));
          for (String _iter15 : this.keysOnly)
          {
            oprot.writeString(_iter15);
          }
          oprot.writeSetEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.fullMap != null) {
      if (isSetFullMap()) {
        oprot.writeFieldBegin(FULL_MAP_FIELD_DESC);
        {
          oprot.writeMapBegin(new TMap(TType.STRING, TType.STRING, this.fullMap.size()));
          for (Map.Entry<String, String> _iter16 : this.fullMap.entrySet())
          {
            oprot.writeString(_iter16.getKey());
            oprot.writeString(_iter16.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("LazyMap(");
    boolean first = true;

    if (isSetKeysOnly()) {
      sb.append("keysOnly:");
      if (this.keysOnly == null) {
        sb.append("null");
      } else {
        sb.append(this.keysOnly);
      }
      first = false;
    }
    if (isSetFullMap()) {
      if (!first) sb.append(", ");
      sb.append("fullMap:");
      if (this.fullMap == null) {
        sb.append("null");
      } else {
        sb.append(this.fullMap);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}


