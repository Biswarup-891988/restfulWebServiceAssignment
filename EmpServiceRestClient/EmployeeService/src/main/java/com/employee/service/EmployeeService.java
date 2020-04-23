package com.employee.service;

import java.util.List;
import java.util.stream.Collectors;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

public class EmployeeService {

  private final EmployeeRepository empRepository;

  public EmployeeService(EmployeeRepository empRepository) {
    this.empRepository = empRepository;
  }

  public List<Employee> getAllEmps() {
    return empRepository.findAll();
  }

  public List<Employee> getEmpByLocation(String location) {
    List<Employee> empList = empRepository.findAll();
    List<Employee> filteredList =
        empList.stream().filter(emp -> emp.getEmpLocation().equalsIgnoreCase(location))
            .collect(Collectors.toList());
    return filteredList;
  }
  
  public List<Employee> getEmpByBand(String empBand) {
    List<Employee> empList = empRepository.findAll();
    List<Employee> filteredList =
        empList.stream().filter(emp -> emp.getEmpBand().equalsIgnoreCase(empBand))
            .collect(Collectors.toList());
    return filteredList;
  }

  public Employee addEmp(Employee emp) {
    return empRepository.save(emp);
  }

  public Employee updateEmp(Employee emp) {
    return empRepository.save(emp);
  }

  public void deleteEmp(String empId) {
    empRepository.deleteById(empId);
  }

}
