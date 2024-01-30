package org.learning.service;

import org.learning.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EmployeeService {

    public List<Employee> getEmployees();
    public Employee getEmployee(Long empId);
    public  boolean addEmployee(Employee employee);
    public  boolean updateEmployeeEmail(String key,String value);
    public  boolean deleteEmployee(Long empId);
}
