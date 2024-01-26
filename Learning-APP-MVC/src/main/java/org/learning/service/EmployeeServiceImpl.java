package org.learning.service;

import org.learning.dao.EmployeeDAO;
import org.learning.enums.UPDATE_TYPE;
import org.learning.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;
    @Override
    public List<Employee> getEmployee() {
        return employeeDAO.getEmployee().stream().filter(e->e.getEmpId()>1).collect(Collectors.toList());
    }

    @Override
    public boolean addEmployee(Employee employee) {

        if(employee.getFirstName()!=null)
        {
            return employeeDAO.addEmployee(employee);
        }
        return  false;
    }

    @Override
    public boolean updateEmployeeEmail(String key,String value) {

        return employeeDAO.updateEmployeeEmail(key, value);

    }

    @Override
    public boolean deleteEmployee(Long empId) {
        return employeeDAO.deleteEmployee(empId);
    }
}
