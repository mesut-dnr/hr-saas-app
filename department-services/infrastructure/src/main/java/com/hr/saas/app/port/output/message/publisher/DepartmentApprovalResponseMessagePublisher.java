package com.hr.saas.app.port.output.message.publisher;

import com.hr.saas.app.model.EmployeeDepartmentApprovalMessage;

public interface DepartmentApprovalResponseMessagePublisher {

    void publish(EmployeeDepartmentApprovalMessage message);
}
