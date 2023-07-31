package com.hr.saas.app.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class CreateEmployeeCommand {

    private final UUID employeeId;

    private final UUID departmentId;

    private final UUID personId;

}
