package com.hr.saas.app.persistence.mapper;


import com.hr.saas.app.persistence.entity.EmployeeEntity;
import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.vo.DepartmentId;
import com.hr.saas.domain.vo.EmployeeId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class EmployeePersistenceMapper {

    public EmployeeEntity employeeToEmployeeEntity(Employee employee){
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .id(employee.getId().getValue())
                //.personId(employee.getCustomerId().getValue())
                .departmentId(employee.getDepartmentId().getValue())
                .employeeHireStatus(employee.getEmployeeHireStatus())
                .failureMessages(employee.getRejectionMessages() != null ?
                        String.join(";", employee.getRejectionMessages()) : " ")
                .build();


        return employeeEntity;
    }

    public Employee employeeEntityToEmployee(EmployeeEntity employeeEntity) {
        return Employee.Builder.builder()
                .employeeId(new EmployeeId(employeeEntity.getId()))
                //.personId(new PersonId(employeeEntity.getPersonId()))
                .departmentId(new DepartmentId(employeeEntity.getDepartmentId()))
                .employeeHireStatus(employeeEntity.getEmployeeHireStatus())
                .failureMessages(employeeEntity.getFailureMessages().isEmpty() ? new ArrayList<>() :
                        new ArrayList<>(Arrays.asList(employeeEntity.getFailureMessages()
                                .split(";"))))
                .build();
    }

}
