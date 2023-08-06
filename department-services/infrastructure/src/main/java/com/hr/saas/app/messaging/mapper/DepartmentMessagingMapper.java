package com.hr.saas.app.messaging.mapper;

import com.hr.saas.app.dto.DepartmentApprovalRequest;
import com.hr.saas.app.kafka.model.avro.DepartmentApprovalRequestAvroModel;
import com.hr.saas.app.kafka.model.avro.DepartmentApprovalResponseAvroModel;
import com.hr.saas.app.kafka.model.avro.DepartmentEmployeeStatus;
import com.hr.saas.app.kafka.model.avro.EmployeeApprovalStatus;
import com.hr.saas.app.model.EmployeeEventPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class DepartmentMessagingMapper {

    public DepartmentApprovalRequest
    departmentApprovalRequestAvroModelToRestaurantApproval(DepartmentApprovalRequestAvroModel
                                                                   departmentApprovalRequestAvroModel) {
        return DepartmentApprovalRequest.builder()
                .id(departmentApprovalRequestAvroModel.getId().toString())
                .sagaId(departmentApprovalRequestAvroModel.getSagaId().toString())
                .departmentId(departmentApprovalRequestAvroModel.getDepartmentId().toString())
                .employeeId(departmentApprovalRequestAvroModel.getEmployeeId().toString())
                .departmentEmployeeStatus(DepartmentEmployeeStatus.valueOf(departmentApprovalRequestAvroModel
                        .getDepartmentEmployeeStatus().name()))
                .createdAt(departmentApprovalRequestAvroModel.getCreatedAt())
                .build();
    }

    public DepartmentApprovalResponseAvroModel
    employeeEventPayloadToDepartmentApprovalResponseAvroModel(String sagaId, EmployeeEventPayload employeeEventPayload) {
        return DepartmentApprovalResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.fromString(sagaId))
                .setEmployeeId(UUID.fromString(employeeEventPayload.getEmployeeId()))
                .setDepartmentId(UUID.fromString(employeeEventPayload.getDepartmentId()))
                .setCreatedAt(employeeEventPayload.getCreatedAt().toInstant())
                .setEmployeeApprovalStatus(EmployeeApprovalStatus.valueOf(employeeEventPayload.getEmployeeApprovalStatus()))
                .setFailureMessages(employeeEventPayload.getFailureMessages())
                .build();
    }
}

