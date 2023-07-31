package com.hr.saas.app.port.input.service;

import com.hr.saas.app.dto.create.CreateEmployeeCommand;
import com.hr.saas.app.dto.create.CreateEmployeeResponse;

public interface EmployeeService {

    CreateEmployeeResponse createEmployee(CreateEmployeeCommand createEmployeeCommand);

}
