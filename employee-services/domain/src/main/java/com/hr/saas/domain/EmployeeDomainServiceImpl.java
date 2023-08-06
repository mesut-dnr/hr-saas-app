package com.hr.saas.domain;

import com.hr.saas.domain.event.EmployeeApprovedEvent;
import com.hr.saas.domain.event.EmployeeCancelledEvent;
import com.hr.saas.domain.event.EmployeeRejectedEvent;
import com.hr.saas.domain.entity.Department;
import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.event.EmployeeCreatedEvent;
import com.hr.saas.domain.exception.EmployeeDomainException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class EmployeeDomainServiceImpl implements EmployeeDomainService {

    private static final String TIME_ZONE_ID = "UTC";

    @Override
    public EmployeeCreatedEvent validateAndInitiateEmployee(Employee employee, Department department) {
        //validateDepartment(department);
        employee.validateEmployee();
        employee.initializeEmployee();
        System.out.println("Employee initiated. ID: " + employee.getId().getValue());
        return new EmployeeCreatedEvent(employee, ZonedDateTime.now((ZoneId.of(TIME_ZONE_ID))));
    }


    @Override
    public EmployeeApprovedEvent approveEmployee(Employee employee) {
        employee.approveEmployee();
        System.out.println("Employee Approved. ID: " + employee.getId().getValue());
        return new EmployeeApprovedEvent(employee, ZonedDateTime.now(ZoneId.of(TIME_ZONE_ID)));
    }

    @Override
    public EmployeeCancelledEvent cancelEmployee(Employee employee, List<String> rejectionMessages) {
        employee.cancelEmployee(rejectionMessages);
        System.out.println("Employee Cancelled. ID: " + employee.getId().getValue());
        return new EmployeeCancelledEvent(employee, ZonedDateTime.now(ZoneId.of(TIME_ZONE_ID)));
    }

    @Override
    public EmployeeRejectedEvent rejectEmployee(Employee employee, List<String> rejectionMessages) {
        employee.rejectEmployee(rejectionMessages);
        System.out.println("Employee Rejected. ID: " + employee.getId().getValue());
        return new EmployeeRejectedEvent(employee, ZonedDateTime.now(ZoneId.of(TIME_ZONE_ID)));

    }

    private void validateDepartment(Department department) {

        if (department.getDepartmentName() == null) {
            throw new EmployeeDomainException("Department name is required");
        }

    }
}
