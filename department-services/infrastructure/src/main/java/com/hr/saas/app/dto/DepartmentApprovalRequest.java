package com.hr.saas.app.dto;

import com.hr.saas.app.kafka.model.avro.DepartmentEmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;


@Getter
@Builder
@AllArgsConstructor
public class DepartmentApprovalRequest {

    private String id;
    private String sagaId;
    private String departmentId;
    private String employeeId;
    private DepartmentEmployeeStatus departmentEmployeeStatus;

    private Instant createdAt;
}
