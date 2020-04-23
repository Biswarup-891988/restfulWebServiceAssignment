package com.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Configuration
public class EmployeeConfig {
  
  @Bean
  public EmployeeService employeeService(EmployeeRepository repo) {
    return new EmployeeService(repo);
  }
  

}
