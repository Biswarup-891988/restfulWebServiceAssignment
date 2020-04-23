package com.emp.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.emp.Exception.EmpServiceException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class EmpClientRestControllerAdvice {

  @ExceptionHandler(EmpServiceException.class)
  public String handleEmpServiceException(EmpServiceException ex) {
    return ex.getMessage();
  }

}
