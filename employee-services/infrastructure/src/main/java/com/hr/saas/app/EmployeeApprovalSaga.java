package com.hr.saas.app;

import com.hr.saas.app.dto.message.DepartmentApprovalResponse;
import com.hr.saas.app.mapper.EmployeeMapper;
import com.hr.saas.app.saga.SagaStatus;
import com.hr.saas.app.saga.SagaStep;
import com.hr.saas.domain.EmployeeDomainService;
import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.event.EmployeeCancelledEvent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeApprovalSaga implements SagaStep<DepartmentApprovalResponse> {

    private final EmployeeSagaHelper employeeSagaHelper;

    private final EmployeeMapper employeeMapper;

    private final EmployeeDomainService employeeDomainService;


    @Override
    @Transactional
    public void process(DepartmentApprovalResponse departmentApprovalResponse) {
        Employee employee = approveEmployee(departmentApprovalResponse);
        SagaStatus sagaStatus = employeeSagaHelper.employeeStatusToSagaStatus(employee.getEmployeeHireStatus());

    }

    private Employee approveEmployee(DepartmentApprovalResponse departmentApprovalResponse) {
        Employee employee = employeeSagaHelper.findEmployee(departmentApprovalResponse.getEmployeeId());
        employeeDomainService.approveEmployee(employee);
        employeeSagaHelper.saveEmployee(employee);
        return employee;
    }

    @Override
    @Transactional
    public void rollBack(DepartmentApprovalResponse departmentApprovalResponse) {

        EmployeeCancelledEvent employeeCancelledEvent = rollBackEmployee(departmentApprovalResponse);

        SagaStatus sagaStatus = employeeSagaHelper.employeeStatusToSagaStatus(employeeCancelledEvent.getEmployee().getEmployeeHireStatus());


        System.out.println("Employee with id is cancelling:" + employeeCancelledEvent.getEmployee().getId().getValue());
    }

    private EmployeeCancelledEvent rollBackEmployee(DepartmentApprovalResponse departmentApprovalResponse) {

        System.out.println("Cancelling Employee with id:" + departmentApprovalResponse.getEmployeeId());
        Employee employee = employeeSagaHelper.findEmployee(departmentApprovalResponse.getEmployeeId());
        EmployeeCancelledEvent employeeCancelledEvent = employeeDomainService.cancelEmployee(employee, departmentApprovalResponse.getFailureMessages());
        employeeSagaHelper.saveEmployee(employee);
        return employeeCancelledEvent;
    }
}
