package com.hr.saas.app.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmployeeServiceError {
    private final String errorCode;
    private final String errorMessage;
}
