package com.hr.saas.app.port.output.repository;

import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.vo.EmployeeId;

import java.util.Optional;

public interface EmployeeRepository {

    Employee save(Employee employee);


    Optional<Employee> findById(EmployeeId employeeId);
}
