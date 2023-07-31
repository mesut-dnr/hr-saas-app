package com.hr.saas.app.persistence.adapter;

import com.hr.saas.app.persistence.mapper.EmployeePersistenceMapper;
import com.hr.saas.app.persistence.repository.EmployeeJpaRepository;
import com.hr.saas.app.port.output.repository.EmployeeRepository;
import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.vo.EmployeeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeJpaRepository employeeJpaRepository;

    private final EmployeePersistenceMapper employeePersistenceMapper;
    @Override
    public Employee save(Employee employee) {
        return employeePersistenceMapper.employeeEntityToEmployee(employeeJpaRepository
                .save(employeePersistenceMapper.employeeToEmployeeEntity(employee)));
    }

    @Override
    public Optional<Employee> findById(EmployeeId employeeId) {
        return employeeJpaRepository.findById(employeeId.getValue()).map(employeePersistenceMapper::employeeEntityToEmployee);
    }
}
