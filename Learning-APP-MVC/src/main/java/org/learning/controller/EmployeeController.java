package org.learning.controller;

import org.learning.pojo.Employee;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
public interface EmployeeController
{
    public List<Employee> getEmployee();
    public  boolean addEmployee();
    public  Employee updateEmployee();

}
