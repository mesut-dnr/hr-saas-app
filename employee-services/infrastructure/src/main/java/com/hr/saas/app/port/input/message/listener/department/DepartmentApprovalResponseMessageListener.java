package com.hr.saas.app.port.input.message.listener.department;

import com.hr.saas.app.dto.message.DepartmentApprovalResponse;

public interface DepartmentApprovalResponseMessageListener {
    void employeeApproved(DepartmentApprovalResponse departmentApprovalResponse);
    void employeeRejected(DepartmentApprovalResponse departmentApprovalResponse);

}
