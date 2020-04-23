package com.employee.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private final EmployeeService empService;

  public EmployeeRestController(EmployeeService empService) {
    this.empService = empService;
  }

  @GetMapping(value = "/allEmp", produces = {"application/xml", "application/json"})
  public ResponseEntity<List<Employee>> getAllEmp() {
    return new ResponseEntity<>(empService.getAllEmps(), HttpStatus.OK);
  }

  @GetMapping(value = "/emp/loc/{location}",
      produces = {"application/xml", "application/json"})
  public ResponseEntity<List<Employee>> getEmpListByLocation(
      @PathVariable("location") String location) {
    List<Employee> empList = empService.getEmpByLocation(location);
    return new ResponseEntity<>(empList, HttpStatus.OK);
  }

  @GetMapping(value = "/emp/band/{empBand}",
      produces = {"application/xml", "application/json"})
  public ResponseEntity<List<Employee>> getEmpListByBand(
      @PathVariable("empBand") String empBand) {
    List<Employee> empList = empService.getEmpByBand(empBand);
    return new ResponseEntity<>(empList, HttpStatus.OK);
  }

  @PostMapping("/addEmp")
  public ResponseEntity addEmp(@RequestBody Employee emp) {
    Employee empDto = empService.addEmp(emp);
    HttpHeaders header = new HttpHeaders();
    header.add("location", "/api/emp/" + empDto.getEmpId());
    return new ResponseEntity<>(header, HttpStatus.CREATED);
  }

  @PutMapping(value = "/updateEmp", produces = {"application/xml", "application/json"})
  public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp) {
    Employee empDto = empService.updateEmp(emp);
    return new ResponseEntity<>(empDto, HttpStatus.OK);
  }

  /* Deleting an existing Employee is not supported at present. */
  @DeleteMapping("/deleteEmp/{empId}")
  @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
  public void deleteEmp(@PathVariable("empId") String empId) {
    // empService.deleteEmp(empId);
  }

}
