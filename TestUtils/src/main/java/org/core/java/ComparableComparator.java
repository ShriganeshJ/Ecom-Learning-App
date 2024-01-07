package org.core.java;

import org.ecom.pojo.Student;
import org.util.classes.ListUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableComparator {


    public static void main(String args[]) {
        comparableInf(ListUtil.getStudentList());
		comparator(ListUtil.getStudentList());

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