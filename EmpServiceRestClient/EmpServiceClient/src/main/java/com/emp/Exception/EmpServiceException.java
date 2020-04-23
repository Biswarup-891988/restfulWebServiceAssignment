package com.emp.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmpServiceException extends Exception {

  private static final long serialVersionUID = 1L;
  private String message;
}
 