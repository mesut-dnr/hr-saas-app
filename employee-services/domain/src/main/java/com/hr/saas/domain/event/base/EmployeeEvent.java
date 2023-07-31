package com.hr.saas.domain.event.base;

import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public abstract class EmployeeEvent implements DomainEvent<Employee> {

    private final Employee employee;

    private final ZonedDateTime createdAt;

    public EmployeeEvent(Employee employee, ZonedDateTime createdAt) {
        this.employee = employee;
        this.createdAt = createdAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}

