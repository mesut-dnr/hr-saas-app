package com.hr.saas.app;

import com.hr.saas.app.dto.create.CreateEmployeeCommand;
import com.hr.saas.app.dto.create.CreateEmployeeResponse;
import com.hr.saas.app.handlers.command.CreateEmployeeCommandHandler;
import com.hr.saas.app.port.input.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final CreateEmployeeCommandHandler createEmployeeCommandHandler;


    @Override
    public CreateEmployeeResponse createEmployee(CreateEmployeeCommand createEmployeeCommand) {
        return createEmployeeCommandHandler.createEmployee(createEmployeeCommand);
    }
}
