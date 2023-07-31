package com.hr.saas.app.port.output.repository;

import com.hr.saas.domain.entity.Department;

import java.util.Optional;
import java.util.UUID;

public interface DepartmentRepository {

    Department save(Department department);

    Optional<Department> findByDepartment(UUID departmentId);
}
