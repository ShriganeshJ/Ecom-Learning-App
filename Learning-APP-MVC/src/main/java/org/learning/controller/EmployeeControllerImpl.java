package org.learning.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.learning.pojo.Employee;
import org.learning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/ecom/getEmployees")
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }

    @PostMapping("/ecom/addEmployees")
    public boolean addEmployee(@RequestBody Employee employee) {

        return employeeService.addEmployee(employee);
    }

    @PutMapping("/ecom/updateEmails")
    public boolean updateEmployee(@RequestBody JsonNode requestBody) {
        String key = requestBody.get("key").asText();
        String value = requestBody.get("value").asText();
        return employeeService.updateEmployeeEmail(value, key);
    }

    @DeleteMapping("/ecom/deleteEmployees/{empId}")
    public boolean deleteEmployee( @PathVariable("empId") Long empId) {
        return employeeService.deleteEmployee(empId);
    }
}
