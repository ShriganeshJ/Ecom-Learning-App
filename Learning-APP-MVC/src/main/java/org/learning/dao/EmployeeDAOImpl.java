package org.learning.dao;

import org.learning.enums.UPDATE_TYPE;
import org.learning.query.Query;
import org.learning.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getEmployee() {
        /**
         * USER ROW MAPPER TO EXTRACT DATA FROM DB
         */
        return jdbcTemplate.query(Query.EMPLOYEE_SELECT_ALL, (resultSet, rowNumber) -> {
            Employee e = new Employee();
            e.setEmpId(Long.parseLong(resultSet.getString("EMP_ID")));
            e.setFirstName(resultSet.getString("FIRST_NAME"));
            e.setLastName(resultSet.getString("LAST_NAME"));
            e.setCity(resultSet.getString("CITI"));
            e.setMobileNo(Long.parseLong(resultSet.getString("MOBILE")));
            e.setEmailId(resultSet.getString("EMAIL"));
            e.setDepartment(resultSet.getString("DEPARTMENT"));
            e.setSalary(Double.parseDouble(resultSet.getString("SALARY")));
            //use ternary operator to handel null
            e.setDob((resultSet.getString("DOB")!=null)?resultSet.getDate("DOB").toLocalDate():null);
            return e;

        });
    }

    @Override
    public boolean addEmployee(Employee employee) {

        int result = jdbcTemplate.update(Query.INSERT_EMPLOYEE, employee.getEmpId(), employee.getFirstName(), employee.getLastName(), employee.getCity(), employee.getMobileNo(), employee.getEmpId(), employee.getDepartment(), employee.getSalary(),employee.getDob());
        // Short form using ternary operator
        return (result > 0) ? true : false;
    }

    @Override
    public boolean updateEmployeeEmail(String key, String value) {
        int result = 0;
        result = jdbcTemplate.update(Query.UPDATE_EMPLOYEE_EMAIL, key, value);

        return (result > 0) ? true : false;
    }
}
