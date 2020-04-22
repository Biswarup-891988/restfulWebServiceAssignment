package com.student.entity;

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
@Table(name = "STUDENT")
public class Student {

  @Id
  private String studentId;
  private String studentName;
  private String studentClass;
  private Double studentTotalMarks;

}
