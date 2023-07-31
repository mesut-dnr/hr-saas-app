package com.hr.saas.app.config;


import com.hr.saas.domain.EmployeeDomainService;
import com.hr.saas.domain.EmployeeDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeServiceBeanConfiguration {

    @Bean
    public EmployeeDomainService orderDomainService(){
        return new EmployeeDomainServiceImpl();
    }
}
