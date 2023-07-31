package com.hr.saas.app;

import com.hr.saas.app.dto.message.DepartmentApprovalResponse;
import com.hr.saas.app.port.input.message.listener.department.DepartmentApprovalResponseMessageListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DepartmentApprovalResponseMessageListenerImpl implements DepartmentApprovalResponseMessageListener {

    private final EmployeeApprovalSaga employeeApprovalSaga;
    @Override
    public void employeeApproved(DepartmentApprovalResponse departmentApprovalResponse) {
        employeeApprovalSaga.process(departmentApprovalResponse);
        System.out.println("Employee Approved for employee id:"+ departmentApprovalResponse.getEmployeeId());
    }

    @Override
    public void employeeRejected(DepartmentApprovalResponse departmentApprovalResponse) {
        employeeApprovalSaga.rollBack(departmentApprovalResponse);
        System.out.println("Employee Rejected for employee id:"+ departmentApprovalResponse.getEmployeeId());
    }
}
