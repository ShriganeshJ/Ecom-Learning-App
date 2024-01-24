package org.learning.service;

import org.learning.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EmployeeService {

    public List<Employee> getEmployee();
    public  boolean addEmployee();
    public  Employee updateEmployee();
}
