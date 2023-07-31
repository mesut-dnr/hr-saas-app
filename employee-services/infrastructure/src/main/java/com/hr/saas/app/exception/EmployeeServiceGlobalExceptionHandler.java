package com.hr.saas.app.exception;


import com.hr.saas.domain.exception.EmployeeDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeServiceGlobalExceptionHandler {



    @ResponseBody
    @ExceptionHandler(value = {EmployeeDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public EmployeeServiceError handleException(EmployeeDomainException employeeDomainException){
        System.out.println("Error handled: " + employeeDomainException.getMessage());
        return EmployeeServiceError
                .builder()
                .errorCode(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .errorMessage(employeeDomainException.getMessage())
                .build();
    }

}
