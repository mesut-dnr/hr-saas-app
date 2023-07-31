package com.hr.saas.domain.exception;

public class EmployeeDomainException extends DomainException{
    public EmployeeDomainException(String message) {
        super(message);
    }

    public EmployeeDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
