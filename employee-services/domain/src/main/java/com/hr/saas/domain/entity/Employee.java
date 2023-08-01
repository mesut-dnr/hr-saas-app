package com.hr.saas.domain.entity;

import com.hr.saas.domain.vo.*;
import com.hr.saas.domain.exception.EmployeeDomainException;

import java.util.List;
import java.util.UUID;


public class Employee extends AggregateRoot<EmployeeId> {

    private final PersonId personId;

    private final DepartmentId departmentId;

    private final JobTitle jobTitle;

    private EmployeeHireStatus employeeHireStatus;

    private List<String> rejectionMessages;

    public void initializeEmployee() {
        setId(new EmployeeId(UUID.randomUUID()));
        employeeHireStatus = EmployeeHireStatus.PENDING;
    }

    public void approveEmployee() {
        if (employeeHireStatus != EmployeeHireStatus.PENDING) {
            throw new EmployeeDomainException("State-status error!");
        }
        employeeHireStatus = EmployeeHireStatus.APPROVED;
    }

    public void rejectEmployee(List<String> rejectionMessages) {
        if (employeeHireStatus != EmployeeHireStatus.PENDING) {
            throw new EmployeeDomainException("State-status error!");
        }
        employeeHireStatus = EmployeeHireStatus.REJECTED;
        generateRejectionMessages(rejectionMessages);
    }

    public void cancelEmployee(List<String> rejectionMessages) {

        employeeHireStatus = EmployeeHireStatus.CANCELLED;
        generateRejectionMessages(rejectionMessages);
    }

    private void generateRejectionMessages(List<String> rejectionMessages) {
        if(this.rejectionMessages!=null && rejectionMessages!=null){
            this.rejectionMessages.addAll(rejectionMessages);
        }
        if(this.rejectionMessages == null){
            this.rejectionMessages = rejectionMessages;
        }
    }

    public void validateEmployee() {
        //validateEmployeeInfo();
        //validatePersonalInfo();
    }

    private void validateEmployeeInfo() {
        if (super.getId() == null) {
            throw new EmployeeDomainException("EmployeeId is null");
        }
    }

    private void validatePersonalInfo() {
        if (personId == null) {
            throw new EmployeeDomainException("personId is null");
        }
    }

    private Employee(Builder builder) {
        super.setId(builder.employeeId);
        personId = builder.personId;
        departmentId = builder.departmentId;
        jobTitle = builder.jobTitle;
        employeeHireStatus = builder.employeeHireStatus;
        rejectionMessages = builder.failureMessages;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public DepartmentId getDepartmentId() {
        return departmentId;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public EmployeeHireStatus getEmployeeHireStatus() {
        return employeeHireStatus;
    }

    public List<String> getRejectionMessages() {
        return rejectionMessages;
    }

    public static final class Builder {
        private EmployeeId employeeId;
        private PersonId personId;
        private DepartmentId departmentId;
        private JobTitle jobTitle;
        private EmployeeHireStatus employeeHireStatus;
        private List<String> failureMessages;

        public Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder employeeId(EmployeeId val) {
            employeeId = val;
            return this;
        }

        public Builder personId(PersonId val) {
            personId = val;
            return this;
        }

        public Builder departmentId(DepartmentId val) {
            departmentId = val;
            return this;
        }

        public Builder jobTitle(JobTitle val) {
            jobTitle = val;
            return this;
        }

        public Builder employeeHireStatus(EmployeeHireStatus val) {
            employeeHireStatus = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
