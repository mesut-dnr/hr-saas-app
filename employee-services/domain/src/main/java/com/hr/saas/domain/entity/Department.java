package com.hr.saas.domain.entity;

import com.hr.saas.domain.vo.DepartmentId;

public class Department extends AggregateRoot<DepartmentId> {
    private String departmentName;

    private Department(Builder builder) {
        super.setId(builder.departmentId);
        departmentName = builder.departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public static final class Builder {
        private DepartmentId departmentId;
        private String departmentName;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(DepartmentId val) {
            departmentId = val;
            return this;
        }

        public Builder departmentName(String val) {
            departmentName = val;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}
