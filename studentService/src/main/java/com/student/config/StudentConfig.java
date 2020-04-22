package com.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@Configuration
public class StudentConfig {
  
  @Bean
  public StudentService studentService(StudentRepository repo) {
    return new StudentService(repo);
  }

}
