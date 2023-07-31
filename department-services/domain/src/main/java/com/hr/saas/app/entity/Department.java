package com.hr.saas.app.entity;

import com.hr.saas.domain.entity.AggregateRoot;
import com.hr.saas.domain.vo.DepartmentId;

public class Department extends AggregateRoot<DepartmentId> {

    private final String departmentName;

    public Department(DepartmentId departmentId,String departmentName) {
        super.setId(departmentId);
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
