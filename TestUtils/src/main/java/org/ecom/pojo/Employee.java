package org.ecom.pojo;

import java.util.Objects;

public class Employee {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                ", Designation='" + Designation + '\'' +
                '}';
    }

    private int id;
    private  String name;
    private double sal;
    private String Designation;


    public Employee(){}

    public Employee(int id, String name, double sal, String designation) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        Designation = designation;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }



}
