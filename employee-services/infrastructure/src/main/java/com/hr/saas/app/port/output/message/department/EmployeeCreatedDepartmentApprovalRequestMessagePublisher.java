package com.hr.saas.app.port.output.message.department;

import com.hr.saas.domain.event.EmployeeCreatedEvent;

public interface EmployeeCreatedDepartmentApprovalRequestMessagePublisher {
    void publish(EmployeeCreatedEvent employeeCreatedEvent);

}
