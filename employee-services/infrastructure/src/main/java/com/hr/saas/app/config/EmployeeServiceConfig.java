package com.hr.saas.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "employee-services")
public class EmployeeServiceConfig {
    private String createEmployeeTopicName;
    private String createEmployeeResponseTopicName;
    private String departmentApprovalRequestTopicName;
    private String departmentApprovalResponseTopicName;
}
