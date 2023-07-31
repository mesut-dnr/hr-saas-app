package com.hr.saas.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;
@Getter
@Builder
@AllArgsConstructor
public class EmployeeEventPayload {

    @JsonProperty
    private String employeeId;

    @JsonProperty
    private String departmentId;

    @JsonProperty
    private ZonedDateTime createdAt;

    @JsonProperty
    private String employeeApprovalStatus;

    @JsonProperty
    private List<String> failureMessages;
}
