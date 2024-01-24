package org.learning.controller;

import org.learning.pojo.Employee;
import org.learning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/api/employees")
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }

    @PostMapping
    public boolean addEmployee() {
        return false;
    }

    @PutMapping
    public Employee updateEmployee() {
        return null;
    }
}
