package org.core.java.stream;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Ths Example we will try to cover max
 * Stream Intermediate and terminal operation
 */
public class StreamAPI {
   private static  List<Student> studentList;
   private static List<Integer>  intList = Arrays.asList(10,6,5,4,3,8,7,6,10,21,9);
   private static List<String> stringList = Arrays.asList("dell","sony","asus","zebronic","gtv");
   private static Map<Integer,Double> resultMap = new HashMap<>();
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
      //add result
        resultMap.put(10,8.42);resultMap.put(17,9.30);resultMap.put(24,6.42);resultMap.put(20,9.42);
        resultMap.put(24,8.42);resultMap.put(16,6.42);resultMap.put(19,8.42);resultMap.put(15,8.32);

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

        /**
         * Calculate  odd Even using filter
         * @filter
         */
        System.out.println("Even no "+ intList.stream().filter(i->i%2==0).collect(Collectors.toList()));


        /***
         *use below method and sort
         * student update grade base on roll no
         * using below method
         * @map
         */
        //we try this using filter but not work bcz filter return boolean values
        List<Student> updateResultList = studentList.stream().map(s->{

            if(resultMap.containsKey(s.getRollNo()))
            {
                s.setGrade(resultMap.get(s.getRollNo()));
            }
            return s;
        }).collect(Collectors.toList());
        System.out.println("Updated Result list is"+updateResultList);


        /**
         * From String [] to Camel case
         * map()
         */
        System.out.println("Camel case "+ stringList.stream().map(i->i.substring(0,1).toUpperCase()+i.substring(1).toLowerCase()).collect(Collectors.toList()));

    }



}
