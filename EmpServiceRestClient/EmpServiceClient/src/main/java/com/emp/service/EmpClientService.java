package com.emp.service;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.emp.Exception.EmpServiceException;
import com.emp.model.Employee;
import reactor.core.publisher.Mono;

@Service
public class EmpClientService {

  private final WebClient webClient;

  public EmpClientService(WebClient webClient) {
    this.webClient = webClient;
  }

  public List<Employee> getAllEmps() throws Exception {
    List<Employee> empList = webClient.get().uri("/allEmp")
        .retrieve()
        .onStatus(HttpStatus::is4xxClientError,
            c -> Mono.error(new EmpServiceException(
                "Recived error with response code: " + c.statusCode())))
        .onStatus(HttpStatus::is4xxClientError,
            c -> Mono.error(new EmpServiceException(
                "Recived error with response code" + c.statusCode())))
        .bodyToMono(new ParameterizedTypeReference<List<Employee>>() {}).block();
    return empList;
  }
  
  public List<Employee> getEmpByLocation(String location) {

    List<Employee> empList = webClient.get().uri("/emp/loc/" + location).retrieve()
        .onStatus(HttpStatus::is4xxClientError,
            c -> Mono.error(new EmpServiceException(
                "Recived error with response code: " + c.statusCode())))
        .onStatus(HttpStatus::is4xxClientError,
            c -> Mono.error(new EmpServiceException(
                "Recived error with response code" + c.statusCode())))
        .bodyToMono(new ParameterizedTypeReference<List<Employee>>() {}).block();
    return empList;
  }

  public List<Employee> getEmpByBand(String empBand) {

    List<Employee> empList = webClient.get().uri("/emp/band/" + empBand).retrieve()
        .onStatus(HttpStatus::is4xxClientError,
            c -> Mono.error(new EmpServiceException(
                "Recived error with response code: " + c.statusCode())))
        .onStatus(HttpStatus::is4xxClientError,
            c -> Mono.error(new EmpServiceException(
                "Recived error with response code" + c.statusCode())))
        .bodyToMono(new ParameterizedTypeReference<List<Employee>>() {}).block();
    return empList;
  }

  public void addEmp(Employee emp) {
        webClient.post().uri("/addEmp").body(Mono.just(emp), Employee.class).retrieve()
            .onStatus(HttpStatus::is4xxClientError,
                c -> Mono.error(new EmpServiceException(
                    "Recived error with response code: " + c.statusCode())))
            .onStatus(HttpStatus::is4xxClientError,
                c -> Mono.error(new EmpServiceException(
                    "Recived error with response code" + c.statusCode())))
            .bodyToMono(Void.class).block();
  }

  public Employee updateEmp(Employee emp) {

    Employee empDto =
        webClient.put().uri("/updateEmp").body(Mono.just(emp), Employee.class).retrieve()
            .onStatus(HttpStatus::is4xxClientError,
                c -> Mono.error(new EmpServiceException(
                    "Recived error with response code: " + c.statusCode())))
            .onStatus(HttpStatus::is4xxClientError,
                c -> Mono.error(new EmpServiceException(
                    "Recived error with response code" + c.statusCode())))
            .bodyToMono(Employee.class).block();
    return empDto;
  }
  
  public void deleteEmp(String empId) {

    webClient.delete().uri("/deleteEmp/" + empId)
        .retrieve()
        .onStatus(HttpStatus::is4xxClientError,
            c -> Mono.error(new EmpServiceException(
                "Recived error with response code: " + c.statusCode())))
        .onStatus(HttpStatus::is4xxClientError,
            c -> Mono.error(new EmpServiceException(
                "Recived error with response code" + c.statusCode())))
        .bodyToMono(Void.class).block();
  }

}
