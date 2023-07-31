package com.hr.saas.domain.event;

import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.event.base.EmployeeEvent;

import java.time.ZonedDateTime;

public class EmployeeApprovedEvent extends EmployeeEvent {

    public EmployeeApprovedEvent(Employee employee, ZonedDateTime createdAt) {
        super(employee, createdAt);
    }
}