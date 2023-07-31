package com.hr.saas.app.event.base;

import com.hr.saas.app.DepartmentDomainService;
import com.hr.saas.app.entity.Department;
import com.hr.saas.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public abstract class DepartmentEvent implements DomainEvent<Department> {

    private final Department department;

    private final ZonedDateTime createdAt;

    public DepartmentEvent(Department department, ZonedDateTime createdAt) {
        this.department = department;
        this.createdAt = createdAt;
    }

    public Department getDepartment() {
        return department;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
