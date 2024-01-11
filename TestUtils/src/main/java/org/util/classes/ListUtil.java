package org.util.classes;

import org.ecom.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    public static List<Student> getStudentList()
    {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        Student student1 = new Student();
        Student student2 = new Student();
        student.setAge(19);
        student.setId("123");
        student.setDepartment("IT");
        student.setFirstName("Zamil");
        student.setLastName("Babu");
        student.setPercentage(10.2);
        student1.setAge(20);
        student1.setId("128");
        student1.setDepartment("EE");
        student1.setFirstName("CBZ");
        student1.setLastName("Babu");
        student1.setPercentage(17.2);
        student2.setAge(22);
        student2.setDepartment("ME");
        student2.setId("1283");
        student2.setFirstName("Mukesh");
        student2.setLastName("sharma");
        student2.setPercentage(18.2);
        list.add(student);list.add(student1);list.add(student2);

        return list;
    }
}
