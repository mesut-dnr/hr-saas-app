package com.hr.saas.app.messaging.mapper;

import com.hr.saas.app.dto.message.DepartmentApprovalResponse;
import com.hr.saas.app.kafka.model.avro.DepartmentApprovalResponseAvroModel;
import com.hr.saas.app.kafka.model.avro.EmployeeApprovalStatus;
import com.hr.saas.app.kafka.model.avro.EmployeeCreateRequestAvroModel;
import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.event.EmployeeCancelledEvent;
import com.hr.saas.domain.event.EmployeeCreatedEvent;

public class EmployeeMessagingMapper {

    public EmployeeCreateRequestAvroModel employeeCreatedEventToAvroModel(EmployeeCreatedEvent employeeCreatedEvent) {
        Employee employee = employeeCreatedEvent.getEmployee();

        return EmployeeCreateRequestAvroModel.newBuilder()
                .setEmployeeId(employee.getId().getValue())
                .setDepartmentId(employee.getDepartmentId().getValue())
                .setPersonId(employee.getPersonId().getValue())
                .setCreatedAt(employeeCreatedEvent.getCreatedAt().toInstant())
                .build();
    }

    public EmployeeCreateRequestAvroModel employeeCancelledEventToAvroModel(EmployeeCancelledEvent employeeCancelledEvent) {
        Employee employee = employeeCancelledEvent.getEmployee();

        return EmployeeCreateRequestAvroModel.newBuilder()
                .setEmployeeId(employee.getId().getValue())
                .setDepartmentId(employee.getDepartmentId().getValue())
                .setPersonId(employee.getPersonId().getValue())
                .setCreatedAt(employeeCancelledEvent.getCreatedAt().toInstant())
                .build();
    }

    public DepartmentApprovalResponse
    approvalResponseAvroModelToApprovalResponse(DepartmentApprovalResponseAvroModel
                                                        departmentApprovalResponseAvroModel) {
        return DepartmentApprovalResponse.builder()
                .id(departmentApprovalResponseAvroModel.getId().toString())
                .sagaId(departmentApprovalResponseAvroModel.getSagaId().toString())
                .departmentId(departmentApprovalResponseAvroModel.getDepartmentId().toString())
                .employeeId(departmentApprovalResponseAvroModel.getEmployeeId().toString())
                .createdAt(departmentApprovalResponseAvroModel.getCreatedAt())
                //.employeeHireStatus()
                .failureMessages(departmentApprovalResponseAvroModel.getFailureMessages())
                .build();
    }
}
