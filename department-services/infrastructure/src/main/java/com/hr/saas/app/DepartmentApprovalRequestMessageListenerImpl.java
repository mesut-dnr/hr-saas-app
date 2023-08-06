package com.hr.saas.app;

import com.hr.saas.app.dto.DepartmentApprovalRequest;
import com.hr.saas.app.port.input.message.listener.employee.DepartmentApprovalRequestMessageListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DepartmentApprovalRequestMessageListenerImpl implements DepartmentApprovalRequestMessageListener {
    @Override
    public void approveEmployee(DepartmentApprovalRequest departmentApprovalRequest) {
        System.out.println("Approval request listened");

    }
}
