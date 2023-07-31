package com.hr.saas.app.port.output.repository;

import com.hr.saas.app.entity.Department;

public interface DepartmentRepository {

    Department createDepartment(Department department);
}
