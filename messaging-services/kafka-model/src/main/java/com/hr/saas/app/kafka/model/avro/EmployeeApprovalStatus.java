/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.hr.saas.app.kafka.model.avro;
@org.apache.avro.specific.AvroGenerated
public enum EmployeeApprovalStatus implements org.apache.avro.generic.GenericEnumSymbol<EmployeeApprovalStatus> {
  APPROVED, REJECTED  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"EmployeeApprovalStatus\",\"namespace\":\"com.hr.saas.app.kafka.model.avro\",\"symbols\":[\"APPROVED\",\"REJECTED\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
