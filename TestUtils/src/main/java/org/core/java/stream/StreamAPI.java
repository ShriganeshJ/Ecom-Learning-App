package org.core.java.stream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * Ths Example we will try to cover max
 * Stream Intermediate and terminal operation
 */
public class StreamAPI {
   private static  List<Student> studentList;
    static {
      studentList  = List.of(
          new Student("raja",10,10000,"D"),
                new Student("raja",10,10000,"D"),
                new Student("mohan",17,20000,"D"),
                new Student("niti",19,170000,"D"),
                new Student("BOB",16,16000,"D"),
                new Student("rohan",16,11000,"D"),
                new Student("Jack",15,12000,"D"),
                new Student("azim",16,13000,"D"),
                new Student("prakash",11,10000,"D"),
                new Student("HOB",24,10000,"D"),
                new Student("TOM",20,10000,"D")
        );
    }
    public static void main(String[] args) {

        /**
         * use below method and remove duplicate
         * select student fee >15000
         * @filter
         * @collect
         */
        System.out.println("Original List"+studentList);
         Set<Student> set= studentList.stream().filter(f->f.getFee()>15000).collect(Collectors.toSet());
        System.out.println("Unique List and > 15000"+set);




    }



}
