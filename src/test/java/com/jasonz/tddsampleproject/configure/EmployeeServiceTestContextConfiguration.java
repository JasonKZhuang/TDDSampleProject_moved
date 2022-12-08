package com.jasonz.tddsampleproject.configure;

import com.jasonz.tddsampleproject.service.EmployeeService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class EmployeeServiceTestContextConfiguration {
    
    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService(null,null) {
            // implement methods
        };
    }
}