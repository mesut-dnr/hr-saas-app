package com.hr.saas.domain;

import com.hr.saas.domain.event.EmployeeApprovedEvent;
import com.hr.saas.domain.event.EmployeeCancelledEvent;
import com.hr.saas.domain.event.EmployeeRejectedEvent;
import com.hr.saas.domain.entity.Department;
import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.event.EmployeeCreatedEvent;

import java.util.List;

public interface EmployeeDomainService {

    EmployeeCreatedEvent validateAndInitiateEmployee(Employee employee, Department department);

    EmployeeApprovedEvent approveEmployee(Employee employee);

    EmployeeCancelledEvent cancelEmployee(Employee employee, List<String> rejectionMessages);

    EmployeeRejectedEvent rejectEmployee(Employee employee, List<String> rejectionMessages);
}
