package com.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

  @Id
  private String empId;
  private String empFirstName;
  private String empLastName;
  private String empLocation;
  private String empBand;

}
