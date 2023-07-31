package com.hr.saas.app.event;

import com.hr.saas.app.entity.Department;
import com.hr.saas.app.event.base.DepartmentEvent;

import java.time.ZonedDateTime;

public class DepartmentApprovedEvent extends DepartmentEvent {
    public DepartmentApprovedEvent(Department department, ZonedDateTime createdAt) {
        super(department, createdAt);
    }
}
