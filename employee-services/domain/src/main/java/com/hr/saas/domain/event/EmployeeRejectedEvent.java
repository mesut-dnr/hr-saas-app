package com.hr.saas.domain.event;

import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.event.base.EmployeeEvent;

import java.time.ZonedDateTime;

public class EmployeeRejectedEvent extends EmployeeEvent {

    public EmployeeRejectedEvent(Employee employee, ZonedDateTime createdAt) {
        super(employee, createdAt);
    }
}
