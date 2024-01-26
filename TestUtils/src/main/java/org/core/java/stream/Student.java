package org.core.java.stream;

import java.util.Objects;

public class Student {

    @Override
    public String toString() {
        return "Student{" +
                "name='" + firstName + '\'' +
                ", rollNo=" + rollNo +
                ", fee=" + fee +
                ", department='" + department + '\'' +
                ", grade=" + grade +
                '}';
    }

    private String firstName;



    private String lastName;
    private int rollNo;
    private double fee;
    private  String department;
    private double grade;



    private int age;

    public Student(String name, String lastName,int rollNo, double fee, String department, double grade) {
        this.firstName = name;
        this.lastName=lastName;
        this.rollNo = rollNo;
        this.fee = fee;
        this.department = department;
        this.grade = grade;
    }



    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }







    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }



    public Student(String name, int rollNo, double fee, String department ,int age) {
        this.firstName = name;
        this.rollNo = rollNo;
        this.fee = fee;
        this.department = department;
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
