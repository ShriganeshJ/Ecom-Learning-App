package org.learing.gs.training;

import org.ecom.pojo.Employee;
import org.ecom.pojo.EmployeeNotFound;

import java.util.HashMap;
import java.util.Map;

public class EmployeeSearch {
    private static Map<Integer, Employee> map = new HashMap<>();

    public static void main(String[] args) throws EmployeeNotFound {
        addEmployee();
        int empId = 123;
        Employee employee = map.get(empId);
        if (employee != null) {
            System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getDesignation() + " " + employee.getSal());
        } else {
            throw new EmployeeNotFound("Employee not found");
        }
    }


    private static void addEmployee() {
        Employee employee1 = new Employee();
        employee1.setId(123);
        employee1.setDesignation("ABC");
        employee1.setName("Dinesh");
        employee1.setSal(100.00);
        Employee employee2 = new Employee();
        employee2.setId(127);
        employee2.setDesignation("ABC");
        employee2.setName("mahesh");
        employee2.setSal(700.00);
        Employee employee3 = new Employee();
        employee3.setId(129);
        employee3.setDesignation("ABC");
        employee3.setName("raj");
        employee3.setSal(170.00);
        Employee employee4 = new Employee();
        employee4.setId(128);
        employee4.setDesignation("ABC");
        employee4.setName("suresh");
        employee4.setSal(150.00);
        Employee employee5 = new Employee();
        employee5.setId(129);
        employee5.setDesignation("ABC");
        employee5.setName("bob");
        employee5.setSal(800.00);
        map.put(employee1.getId(), employee1);
        map.put(employee2.getId(), employee2);
        map.put(employee3.getId(), employee3);
        map.put(employee4.getId(), employee4);
        map.put(employee5.getId(), employee5);
    }

}
