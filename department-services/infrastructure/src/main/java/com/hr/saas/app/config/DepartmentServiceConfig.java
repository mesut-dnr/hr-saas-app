package com.hr.saas.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "department-services")
public class DepartmentServiceConfig {
    private String createEmployeeRequestTopicName;
    private String createEmployeeResponseTopicName;
    private String departmentApprovalRequestTopicName;
    private String departmentApprovalResponseTopicName;
}
