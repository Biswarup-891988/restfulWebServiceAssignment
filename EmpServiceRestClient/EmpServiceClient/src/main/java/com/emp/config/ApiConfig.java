package com.emp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApiConfig {

  @Bean
  public WebClient webClient() {
    return WebClient.builder().baseUrl("http://localhost:8081/api").build();
  }

}
