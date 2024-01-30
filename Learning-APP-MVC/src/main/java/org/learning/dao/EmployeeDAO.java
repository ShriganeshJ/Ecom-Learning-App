package org.learning.dao;

import org.learning.pojo.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getEmployees();
    public  boolean addEmployee(Employee employee);
    public  boolean updateEmployeeEmail(String key,String value);
    public boolean deleteEmployee(Long empId);
    public Employee getEmployee(long id);

}
