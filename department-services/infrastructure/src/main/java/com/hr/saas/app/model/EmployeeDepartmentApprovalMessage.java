package com.hr.saas.app.model;


import com.hr.saas.domain.vo.EmployeeApprovalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class EmployeeDepartmentApprovalMessage {

    private UUID id;
    private UUID sagaId;
    private ZonedDateTime createdAt;
    private ZonedDateTime processedAt;
    private String type;
    private String payload;
    private EmployeeApprovalStatus employeeApprovalStatus;
    private int version;
}
