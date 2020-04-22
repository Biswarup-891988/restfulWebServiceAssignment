package com.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.movie.service.MovieService;

@Configuration
public class MovieApiConfig {

  @Bean
  public MovieService movieService() {
    return new MovieService();
  }

}
