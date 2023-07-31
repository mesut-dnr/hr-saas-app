package com.hr.saas.app.mapper;

import com.hr.saas.app.dto.create.CreateEmployeeCommand;
import com.hr.saas.app.dto.create.CreateEmployeeResponse;
import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.vo.DepartmentId;
import com.hr.saas.domain.vo.PersonId;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee commandToEntity(CreateEmployeeCommand createEmployeeCommand) {
        //TODO: ADD job title to mapper
        return new Employee.Builder()
                .departmentId(new DepartmentId(createEmployeeCommand.getDepartmentId()))
                .personId(new PersonId(createEmployeeCommand.getPersonId()))
                .build();
    }

    public CreateEmployeeResponse employeeToCreateEmployeeResponse(Employee employee){
        return CreateEmployeeResponse.builder()
                .message("success")
                .employeeHireStatus(employee.getEmployeeHireStatus())
                .build();
    }

}
