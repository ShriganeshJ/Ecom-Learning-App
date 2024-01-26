package org.learning.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.learning.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
public interface EmployeeController
{
    public List<Employee> getEmployee();
    public  boolean addEmployee(Employee employee);
    public  boolean updateEmployee(JsonNode requestBody);
    public boolean deleteEmployee();

}
