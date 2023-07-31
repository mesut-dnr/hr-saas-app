package com.hr.saas.app.persistence.adapter;


import com.hr.saas.app.entity.Department;
import com.hr.saas.app.persistence.mapper.DepartmentPersistenceMapper;
import com.hr.saas.app.persistence.repository.DepartmentJpaRepository;
import com.hr.saas.app.port.output.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final DepartmentJpaRepository departmentJpaRepository;

    private final DepartmentPersistenceMapper departmentPersistenceMapper;

    @Override
    public Department createDepartment(Department department) {
        return departmentPersistenceMapper.departmentEntityToDepartment(
                departmentJpaRepository.save(departmentPersistenceMapper.departmentToDepartmentEntity(department)));

    }
}
