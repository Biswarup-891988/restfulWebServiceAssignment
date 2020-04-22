package com.student.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  private final StudentService studentService;

  public StudentRestController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/allStudent")
  public ResponseEntity<List<Student>> getAllStudent() {
    return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
  }

  @GetMapping("/student/{studentId}")
  public ResponseEntity<Student> getStudent(@PathVariable("studentId") String studentId) {

    Optional<Student> student = studentService.getStudent(studentId);
    if (student.isPresent()) {
      return new ResponseEntity<>(student.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/studentHighMarks/{studentMark}")
  public ResponseEntity<List<Student>> getStudentWithHighestMark(
      @PathVariable("studentMark") Double studentMark) {

    List<Student> studentList = studentService.getStudentWithHighestMark(studentMark);
    return new ResponseEntity<>(studentList, HttpStatus.OK);
  }

  @PostMapping("/addStudent")
  public ResponseEntity addStudent(@RequestBody Student student) {
    Student studentDto = studentService.addStudent(student);
    HttpHeaders header = new HttpHeaders();
    header.add("location", "/api/" + studentDto.getStudentId());
    return new ResponseEntity<>(header, HttpStatus.CREATED);
  }

  @PutMapping("/updateStudent")
  public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
    Student studentDto = studentService.updateStudent(student);
    return new ResponseEntity<>(studentDto, HttpStatus.OK);
  }

  @DeleteMapping("/deleteStudent/{studentId}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteStudent(@PathVariable("studentId") String studentId) {
    studentService.deleteStudent(studentId);

  }
}
