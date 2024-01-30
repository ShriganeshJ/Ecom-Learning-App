package org.learning.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.learning.pojo.Employee;
import org.learning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/ecom/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/ecom/employees/{empId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("empId") long empId)
    {
        return new ResponseEntity<>(employeeService.getEmployee(empId), HttpStatus.OK);
    }

    @PostMapping("/ecom/employees")
    public boolean addEmployee(@RequestBody Employee employee) {

        return employeeService.addEmployee(employee);
    }

    @PutMapping("/ecom/employees")
    public boolean updateEmployee(@RequestBody JsonNode requestBody) {
        String key = requestBody.get("key").asText();
        String value = requestBody.get("value").asText();
        return employeeService.updateEmployeeEmail(value, key);
    }

    @DeleteMapping("/ecom/employees/{empId}")
    public boolean deleteEmployee( @PathVariable("empId") Long empId) {
        return employeeService.deleteEmployee(empId);
    }
}
