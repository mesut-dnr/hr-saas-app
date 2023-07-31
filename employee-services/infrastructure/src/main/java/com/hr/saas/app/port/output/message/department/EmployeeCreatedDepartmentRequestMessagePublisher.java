package com.hr.saas.app.port.output.message.department;

import com.hr.saas.domain.event.EmployeeCreatedEvent;
import com.hr.saas.domain.event.publisher.DomainEventPublisher;

public interface EmployeeCreatedDepartmentRequestMessagePublisher {
    void publish(EmployeeCreatedEvent employeeCreatedEvent);

}
