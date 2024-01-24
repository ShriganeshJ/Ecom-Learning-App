package org.learning.service;

import org.learning.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> getEmployee() {
        Employee employee = new Employee();
        employee.setCity("Pune");
        employee.setEmpId(145);
        employee.setFirstName("raja");
        employee.setLastName("Babu");
        return List.of(employee);
    }

    @Override
    public boolean addEmployee() {
        return false;
    }

    @Override
    public Employee updateEmployee() {
        return null;
    }
}
