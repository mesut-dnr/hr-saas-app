package com.hr.saas.app;


import com.hr.saas.app.port.output.repository.EmployeeRepository;
import com.hr.saas.app.saga.SagaStatus;
import com.hr.saas.domain.entity.Employee;
import com.hr.saas.domain.vo.EmployeeHireStatus;
import com.hr.saas.domain.vo.EmployeeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeSagaHelper {
    private final EmployeeRepository employeeRepository;

    Employee findEmployee(String employeeId) {
        Optional<Employee> employeeResponse = employeeRepository.findById(new EmployeeId(UUID.fromString(employeeId)));
        if (employeeResponse.isEmpty()) {
            System.out.println("Order with id: {} could not be found"+employeeId);
            // TODO: throw EmployeeNotFoundException
        }
        return employeeResponse.get();
    }

    void saveEmployee(Employee order){
        employeeRepository.save(order);
    }

    SagaStatus employeeStatusToSagaStatus(EmployeeHireStatus employeeHireStatus){
        switch (employeeHireStatus){
            case PENDING:
                return SagaStatus.PROCESSING;
            case APPROVED:
                return SagaStatus.SUCCEEDED;
            case REJECTED:
                return SagaStatus.COMPENSATING;
            case CANCELLED:
                return SagaStatus.COMPENSATED;
            default:
                return SagaStatus.STARTED;
        }
    }

}
