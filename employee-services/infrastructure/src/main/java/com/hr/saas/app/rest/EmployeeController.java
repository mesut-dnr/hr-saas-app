package com.hr.saas.app.rest;


import com.hr.saas.app.dto.create.CreateEmployeeCommand;
import com.hr.saas.app.dto.create.CreateEmployeeResponse;
import com.hr.saas.app.port.input.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@RequestBody CreateEmployeeCommand createEmployeeCommand) {

        CreateEmployeeResponse createEmployeeResponse = employeeService.createEmployee(createEmployeeCommand);

        return ResponseEntity.ok(createEmployeeResponse);
    }
}
