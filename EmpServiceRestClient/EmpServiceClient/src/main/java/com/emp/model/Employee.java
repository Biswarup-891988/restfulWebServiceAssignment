package com.emp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employee {

  private String empId;
  private String empFirstName;
  private String empLastName;
  private String empLocation;
  private String empBand;
}
