package com.student.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Optional<Student> getStudent(String studentId) {
    return studentRepository.findById(studentId);
  }

  public List<Student> getStudentWithHighestMark(Double studentMark) {
    List<Student> studentList = studentRepository.findAll();
    List<Student> filteredList = studentList.stream()
        .filter(s -> s.getStudentTotalMarks() > studentMark).collect(Collectors.toList());
    return filteredList;
  }

  public Student addStudent(Student student) {
    return studentRepository.save(student);
  }

  public Student updateStudent(Student student) {
    return studentRepository.save(student);
  }

  public void deleteStudent(String studentId) {
    studentRepository.deleteById(studentId);
  }

  public List<Student> getStudentsInSameClass(String studentClass) {
    List<Student> studentList = studentRepository.findAll();
    List<Student> filteredList = studentList.stream()
        .filter(s -> s.getStudentClass().equalsIgnoreCase(studentClass))
        .collect(Collectors.toList());
    return filteredList;
  }

}
