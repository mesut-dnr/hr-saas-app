package com.hr.saas.app.dto.create;


import com.hr.saas.domain.vo.EmployeeHireStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CreateEmployeeResponse {

    private final EmployeeHireStatus employeeHireStatus;
    private final String message;
}
