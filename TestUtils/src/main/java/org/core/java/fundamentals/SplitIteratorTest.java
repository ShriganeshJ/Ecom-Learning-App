package org.core.java.fundamentals;

import org.ecom.pojo.Student;
import org.util.classes.ListUtil;

import java.util.List;
import java.util.Spliterator;

public class SplitIteratorTest {

    public static void main(String[] args) {
    splitIteratorExample();
    }

    /**
     * 1.Java Spliterator is an interface in Java Collection API.
     * 2.Spliterator is introduced in Java 8 release in java.util package.
     * 3.It supports Parallel Programming functionality.
     * 4.We can use it for both Collection API and Stream API classes.
     * 5.It provides characteristics about Collection or API objects.
     * 6.We can NOT use this Iterator for Map implemented classes.
     * 7.It uses tryAdvance() method to iterate elements individually in multiple Threads to support Parallel Processing.
     * 8.It uses forEachRemaining() method to iterate elements sequentially in a single Thread.
     * 9.It uses trySplit() method to divide itself into Sub-Spliterators to support Parallel Processing.
     * 10.Spliterator supports both Sequential and Parallel processing of data.
     */
    private static void splitIteratorExample()
    {
        List<Student> studentList = ListUtil.getStudentList();
        // Get the spliterator for the list
        Spliterator<Student> spliterator = studentList.spliterator();

        // Perform parallel processing using forEachRemaining
        spliterator.forEachRemaining(System.out::println);
    }


}
