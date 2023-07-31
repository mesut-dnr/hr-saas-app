/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.hr.saas.app.kafka.model.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EmployeeCreateRequestAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4387353256521434704L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EmployeeCreateRequestAvroModel\",\"namespace\":\"com.hr.saas.app.kafka.model.avro\",\"fields\":[{\"name\":\"employeeId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"departmentId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"personId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.UUIDConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<EmployeeCreateRequestAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EmployeeCreateRequestAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EmployeeCreateRequestAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EmployeeCreateRequestAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EmployeeCreateRequestAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EmployeeCreateRequestAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EmployeeCreateRequestAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EmployeeCreateRequestAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EmployeeCreateRequestAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.util.UUID employeeId;
  private java.util.UUID departmentId;
  private java.util.UUID personId;
  private java.time.Instant createdAt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EmployeeCreateRequestAvroModel() {}

  /**
   * All-args constructor.
   * @param employeeId The new value for employeeId
   * @param departmentId The new value for departmentId
   * @param personId The new value for personId
   * @param createdAt The new value for createdAt
   */
  public EmployeeCreateRequestAvroModel(java.util.UUID employeeId, java.util.UUID departmentId, java.util.UUID personId, java.time.Instant createdAt) {
    this.employeeId = employeeId;
    this.departmentId = departmentId;
    this.personId = personId;
    this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return employeeId;
    case 1: return departmentId;
    case 2: return personId;
    case 3: return createdAt;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: employeeId = (java.util.UUID)value$; break;
    case 1: departmentId = (java.util.UUID)value$; break;
    case 2: personId = (java.util.UUID)value$; break;
    case 3: createdAt = (java.time.Instant)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'employeeId' field.
   * @return The value of the 'employeeId' field.
   */
  public java.util.UUID getEmployeeId() {
    return employeeId;
  }


  /**
   * Sets the value of the 'employeeId' field.
   * @param value the value to set.
   */
  public void setEmployeeId(java.util.UUID value) {
    this.employeeId = value;
  }

  /**
   * Gets the value of the 'departmentId' field.
   * @return The value of the 'departmentId' field.
   */
  public java.util.UUID getDepartmentId() {
    return departmentId;
  }


  /**
   * Sets the value of the 'departmentId' field.
   * @param value the value to set.
   */
  public void setDepartmentId(java.util.UUID value) {
    this.departmentId = value;
  }

  /**
   * Gets the value of the 'personId' field.
   * @return The value of the 'personId' field.
   */
  public java.util.UUID getPersonId() {
    return personId;
  }


  /**
   * Sets the value of the 'personId' field.
   * @param value the value to set.
   */
  public void setPersonId(java.util.UUID value) {
    this.personId = value;
  }

  /**
   * Gets the value of the 'createdAt' field.
   * @return The value of the 'createdAt' field.
   */
  public java.time.Instant getCreatedAt() {
    return createdAt;
  }


  /**
   * Sets the value of the 'createdAt' field.
   * @param value the value to set.
   */
  public void setCreatedAt(java.time.Instant value) {
    this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Creates a new EmployeeCreateRequestAvroModel RecordBuilder.
   * @return A new EmployeeCreateRequestAvroModel RecordBuilder
   */
  public static com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder newBuilder() {
    return new com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder();
  }

  /**
   * Creates a new EmployeeCreateRequestAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EmployeeCreateRequestAvroModel RecordBuilder
   */
  public static com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder newBuilder(com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder other) {
    if (other == null) {
      return new com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder();
    } else {
      return new com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new EmployeeCreateRequestAvroModel RecordBuilder by copying an existing EmployeeCreateRequestAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new EmployeeCreateRequestAvroModel RecordBuilder
   */
  public static com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder newBuilder(com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel other) {
    if (other == null) {
      return new com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder();
    } else {
      return new com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for EmployeeCreateRequestAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EmployeeCreateRequestAvroModel>
    implements org.apache.avro.data.RecordBuilder<EmployeeCreateRequestAvroModel> {

    private java.util.UUID employeeId;
    private java.util.UUID departmentId;
    private java.util.UUID personId;
    private java.time.Instant createdAt;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.employeeId)) {
        this.employeeId = data().deepCopy(fields()[0].schema(), other.employeeId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.departmentId)) {
        this.departmentId = data().deepCopy(fields()[1].schema(), other.departmentId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.personId)) {
        this.personId = data().deepCopy(fields()[2].schema(), other.personId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[3].schema(), other.createdAt);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing EmployeeCreateRequestAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.employeeId)) {
        this.employeeId = data().deepCopy(fields()[0].schema(), other.employeeId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.departmentId)) {
        this.departmentId = data().deepCopy(fields()[1].schema(), other.departmentId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.personId)) {
        this.personId = data().deepCopy(fields()[2].schema(), other.personId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[3].schema(), other.createdAt);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'employeeId' field.
      * @return The value.
      */
    public java.util.UUID getEmployeeId() {
      return employeeId;
    }


    /**
      * Sets the value of the 'employeeId' field.
      * @param value The value of 'employeeId'.
      * @return This builder.
      */
    public com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder setEmployeeId(java.util.UUID value) {
      validate(fields()[0], value);
      this.employeeId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'employeeId' field has been set.
      * @return True if the 'employeeId' field has been set, false otherwise.
      */
    public boolean hasEmployeeId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'employeeId' field.
      * @return This builder.
      */
    public com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder clearEmployeeId() {
      employeeId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'departmentId' field.
      * @return The value.
      */
    public java.util.UUID getDepartmentId() {
      return departmentId;
    }


    /**
      * Sets the value of the 'departmentId' field.
      * @param value The value of 'departmentId'.
      * @return This builder.
      */
    public com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder setDepartmentId(java.util.UUID value) {
      validate(fields()[1], value);
      this.departmentId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'departmentId' field has been set.
      * @return True if the 'departmentId' field has been set, false otherwise.
      */
    public boolean hasDepartmentId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'departmentId' field.
      * @return This builder.
      */
    public com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder clearDepartmentId() {
      departmentId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'personId' field.
      * @return The value.
      */
    public java.util.UUID getPersonId() {
      return personId;
    }


    /**
      * Sets the value of the 'personId' field.
      * @param value The value of 'personId'.
      * @return This builder.
      */
    public com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder setPersonId(java.util.UUID value) {
      validate(fields()[2], value);
      this.personId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'personId' field has been set.
      * @return True if the 'personId' field has been set, false otherwise.
      */
    public boolean hasPersonId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'personId' field.
      * @return This builder.
      */
    public com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder clearPersonId() {
      personId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdAt' field.
      * @return The value.
      */
    public java.time.Instant getCreatedAt() {
      return createdAt;
    }


    /**
      * Sets the value of the 'createdAt' field.
      * @param value The value of 'createdAt'.
      * @return This builder.
      */
    public com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder setCreatedAt(java.time.Instant value) {
      validate(fields()[3], value);
      this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel.Builder clearCreatedAt() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EmployeeCreateRequestAvroModel build() {
      try {
        EmployeeCreateRequestAvroModel record = new EmployeeCreateRequestAvroModel();
        record.employeeId = fieldSetFlags()[0] ? this.employeeId : (java.util.UUID) defaultValue(fields()[0]);
        record.departmentId = fieldSetFlags()[1] ? this.departmentId : (java.util.UUID) defaultValue(fields()[1]);
        record.personId = fieldSetFlags()[2] ? this.personId : (java.util.UUID) defaultValue(fields()[2]);
        record.createdAt = fieldSetFlags()[3] ? this.createdAt : (java.time.Instant) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EmployeeCreateRequestAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<EmployeeCreateRequestAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EmployeeCreateRequestAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<EmployeeCreateRequestAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}









