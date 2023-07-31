package com.hr.saas.app.dto.message;

import com.hr.saas.domain.vo.EmployeeHireStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class DepartmentApprovalResponse {

    private String id;
    private String sagaId;
    private String employeeId;
    private String departmentId;
    private Instant createdAt;
    private EmployeeHireStatus employeeHireStatus;
    private List<String> failureMessages;
}
