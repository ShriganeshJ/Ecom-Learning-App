package org.core.java;

import org.ecom.pojo.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableComparator {


    public static void main(String args[]) {
        Student student = new Student();
        Student student1 = new Student();
        Student student2 = new Student();
        student.setAge(19);
        student.setDepartment("IT");
        student.setFirstName("Zamil");
        student.setLastName("Babu");
        student.setPercentage(10.2);
        student1.setAge(20);
        student1.setDepartment("EE");
        student1.setFirstName("CBZ");
        student1.setLastName("Babu");
        student1.setPercentage(17.2);
        student2.setAge(22);
        student2.setDepartment("ME");
        student2.setFirstName("Mukesh");
        student2.setLastName("sharma");
        student2.setPercentage(18.2);
        comparableInf(Arrays.asList(student, student1, student2));
		comparator(Arrays.asList(student, student1, student2));

    }

    public static void comparator(List<Student> studentList) {
        Collections.sort(studentList, Comparator.comparing(Student::getAge).thenComparing(Student::getFirstName));
        System.out.println("Using Name and Age");
        for (Student student : studentList) {
            System.out.print(student.getFirstName() + " ");
            System.out.print(student.getLastName() + " ");
            System.out.print(student.getDepartment() + " ");
            System.out.print(student.getAge());
            System.out.println();

        }

    }

    public static void comparableInf(List<Student> studentList) {
        System.out.println("Using  Age");
        Collections.sort(studentList);
        for (Student student : studentList) {
            System.out.print(student.getFirstName() + " ");
            System.out.print(student.getLastName() + " ");
            System.out.print(student.getDepartment() + " ");
            System.out.print(student.getAge());
            System.out.println();

        }
    }

}