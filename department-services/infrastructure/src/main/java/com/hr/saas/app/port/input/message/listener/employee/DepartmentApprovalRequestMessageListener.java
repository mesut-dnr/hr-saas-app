package com.hr.saas.app.port.input.message.listener.employee;

import com.hr.saas.app.dto.DepartmentApprovalRequest;

public interface DepartmentApprovalRequestMessageListener {

    void approveEmployee(DepartmentApprovalRequest departmentApprovalRequest);
}
