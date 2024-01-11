package org.ecom.pojo;

public class Student implements  Comparable<Student>
{
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", percentage=" + percentage +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    private String id;
private String lastName;
private String firstName;
private String department;
private int age;
private double percentage;



    @Override
    public int compareTo(Student s) {

        if(this.age==s.age) {
            return 0;
        } else if (this.age>s.age) {
            return 1111;
        }
        return -111;
    }
}