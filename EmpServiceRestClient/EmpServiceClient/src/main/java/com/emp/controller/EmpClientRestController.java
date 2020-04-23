package com.emp.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.emp.model.Employee;
import com.emp.service.EmpClientService;

@RestController
@RequestMapping("/client")
public class EmpClientRestController {
  
  private final EmpClientService empClientService;

  public EmpClientRestController(EmpClientService empClientService) {
    this.empClientService = empClientService;
  }
  
  @GetMapping(value = "/allEmp")
  public ResponseEntity<List<Employee>> getAllEmp() throws Exception {
    return new ResponseEntity<>(empClientService.getAllEmps(), HttpStatus.OK);
  }

  @GetMapping(value = "/emp/loc/{location}",
      produces = {"application/xml", "application/json"})
  public ResponseEntity<List<Employee>> getEmpListByLocation(
      @PathVariable("location") String location) {
    List<Employee> empList = empClientService.getEmpByLocation(location);
    return new ResponseEntity<>(empList, HttpStatus.OK);
  }

  @GetMapping(value = "/emp/band/{empBand}",
      produces = {"application/xml", "application/json"})
  public ResponseEntity<List<Employee>> getEmpListByBand(
      @PathVariable("empBand") String empBand) {
    List<Employee> empList = empClientService.getEmpByBand(empBand);
    return new ResponseEntity<>(empList, HttpStatus.OK);
  }

  @PostMapping("/addEmp")
  @ResponseStatus(value = HttpStatus.CREATED)
  public void addEmp(@RequestBody Employee emp) {
     empClientService.addEmp(emp);
  }

  @PutMapping(value = "/updateEmp", produces = {"application/xml", "application/json"})
  public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp) {
    Employee empDto = empClientService.updateEmp(emp);
    return new ResponseEntity<>(empDto, HttpStatus.OK);
  }

  @DeleteMapping("/deleteEmp/{empId}")
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteEmp(@PathVariable("empId") String empId) {
     empClientService.deleteEmp(empId);
  }
  

}
