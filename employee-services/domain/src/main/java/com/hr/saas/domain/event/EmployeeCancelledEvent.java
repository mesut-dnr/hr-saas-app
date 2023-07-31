package com.hr.saas.domain.event;

import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.event.base.EmployeeEvent;

import java.time.ZonedDateTime;

public class EmployeeCancelledEvent extends EmployeeEvent {

    public EmployeeCancelledEvent(Employee employee, ZonedDateTime createdAt) {
        super(employee, createdAt);
    }
}