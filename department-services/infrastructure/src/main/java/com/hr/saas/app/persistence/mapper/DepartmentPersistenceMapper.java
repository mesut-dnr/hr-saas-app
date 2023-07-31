package com.hr.saas.app.persistence.mapper;


import com.hr.saas.app.entity.Department;
import com.hr.saas.app.persistence.entity.DepartmentEntity;
import com.hr.saas.domain.vo.DepartmentId;
import org.springframework.stereotype.Component;

@Component
public class DepartmentPersistenceMapper {

    public Department departmentEntityToDepartment(DepartmentEntity departmentEntity) {
        return new Department(new DepartmentId(departmentEntity.getDepartmentId()),
                departmentEntity.getDepartmentName());

    }

    public DepartmentEntity departmentToDepartmentEntity(Department department) {
        return DepartmentEntity.builder()
                .departmentId(department.getId().getValue())
                .departmentName(department.getDepartmentName())
                .build();
    }
}
