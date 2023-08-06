package com.hr.saas.app.handlers.command;

import com.hr.saas.app.dto.create.CreateEmployeeCommand;
import com.hr.saas.app.dto.create.CreateEmployeeResponse;
import com.hr.saas.app.mapper.EmployeeMapper;
import com.hr.saas.app.port.output.message.department.EmployeeCreatedDepartmentApprovalRequestMessagePublisher;
import com.hr.saas.app.port.output.repository.EmployeeRepository;
import com.hr.saas.domain.EmployeeDomainService;
import com.hr.saas.domain.entity.Department;
import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.event.EmployeeCreatedEvent;
import com.hr.saas.domain.exception.EmployeeDomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateEmployeeCommandHandler {

    private final EmployeeDomainService employeeDomainService;

    private final EmployeeRepository employeeRepository;


    // private final DepartmentRepository departmentRepository;

    private final EmployeeMapper employeeMapper;

    private final EmployeeCreatedDepartmentApprovalRequestMessagePublisher publisher;

    @Transactional
    public CreateEmployeeResponse createEmployee(CreateEmployeeCommand createEmployeeCommand) {
        //checkDepartment(createEmployeeCommand.getDepartmentId());


        Employee employee = employeeMapper.commandToEntity(createEmployeeCommand);
        Department department = Department.Builder.builder().departmentName("test").build();

        //departmentRepository.findByDepartment(createEmployeeCommand.getDepartmentId()).get();

        EmployeeCreatedEvent employeeCreatedEvent = employeeDomainService
                .validateAndInitiateEmployee(employee, department);

        Employee employeeFinal = saveEmployee(employee);
        System.out.println("Employee created with id:" + employeeFinal.getId().getValue());

        publisher.publish(employeeCreatedEvent);

        return employeeMapper
                .employeeToCreateEmployeeResponse(employeeFinal);

    }

    private void checkDepartment(UUID departmentId) {
//        Optional<Department> department = departmentRepository.findByDepartment(departmentId);
//
//        if (department.isEmpty()) {
//            System.out.println("There is no person with the id: " + departmentId);
//            throw new EmployeeDomainException("There is no person with the id: " + departmentId);
//        }
    }


    private Employee saveEmployee(Employee employee) {
        Employee employeeResult = employeeRepository.save(employee);
        if (employeeResult == null) {
            System.out.println("Could not save employee :" + employee.getId().getValue());
            throw new EmployeeDomainException("Could not save employee");
        }
        System.out.println("Employee is saved successfully :" + employeeResult.getId().getValue());
        return employeeResult;
    }
}
