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
   private static List<Integer>  intList = Arrays.asList(2,10,6,5,4,3,8,7,6,10,21,9);
   private static List<String> stringList = Arrays.asList("dell","sony","asus","zebronic","gtv");
   private static Map<Integer,Double> resultMap = new HashMap<>();
   private static   List<Person> peoples;
    static {
      studentList  = List.of(
          new Student("raja","ram",10,10000,"D",8.63),
                new Student("raja","rao",10,10000,"D",7.63),
                new Student("mohan","pal",17,20000,"D",8.32),
                new Student("niti","yaday",19,170000,"D",6.32),
                new Student("BOB","morgan",16,16000,"D",9.35),
                new Student("rohan","mocizo",16,11000,"D",9.68),
                new Student("Jack","samsu",15,12000,"D",8.28),
                new Student("azim","shek",16,13000,"D",9.30),
                new Student("prakash","",11,10000,"D",7.63),
                new Student("HOB","peter",24,10000,"D",5.16),
                new Student("TOM","cruz",20,10000,"D",6.19)
        );

       peoples = Arrays.asList(
                new Person("Alice", Arrays.asList("123", "456")),
                new Person("Bob", Arrays.asList("789", "012")),
                new Person("Charlie", Arrays.asList("345", "678"))
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

        /**
         * Get sum of even integer from array
         * mapToInt()
         * @mapToInt()
         * @filter()
         * @sum()
         */

        Integer sum = intList.stream().filter(i->i%2==0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of Even no "+sum);


        /**
         * Get count of student age>20
         * @filter()
         * @count()
         */

        Long count = studentList.stream().filter(s->s.getAge()>20).count();
        System.out.println("count of student age >20 :is "+count);
        /**
         * IntSummaryStatistics using this class get sum,min,max,avg
         * @summaryStatistics()
         */

        IntSummaryStatistics intSummaryStatistics = intList.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("SummaryStatics "+intSummaryStatistics);
        /**
         * Join first and list name using
         * @Collectors.joining()
         */
        System.out.println("joining::"+studentList.stream().map(Student::getName).collect(Collectors.joining(",","{","}")));

        /**
         *
         *Get all phone no from list of list collection
         * @flatMap()
         */

        List<String> mobileNoList = peoples.stream().flatMap(i->i.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println("No are "+ mobileNoList);

        /**
         * @sorted()
         * sort by grade
         */
        System.out.println("List of stud sorted by grade"+studentList.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).collect(Collectors.toList()));

        /**
         * min max element from array
         * @min()
         * @max()
         */
        System.out.println("Min "+intList.stream().mapToInt(i->i.intValue()).min().getAsInt());
        System.out.println("Max "+intList.stream().mapToInt(i->i.intValue()).max().getAsInt());

        /**
         * reduce method
         * min(),max(),sum(),avg() internally use this method
         * @reduce()
         */

        String longestString  =stringList.stream().reduce((w1,w2)->w1.length()>w2.length()?w1:w2).get();
        Integer reduceSum01 = intList.stream().reduce((a,b)->a+b).get();
        System.out.println("Reduce sume "+reduceSum01);

        System.out.println("Long String is "+longestString);

        Integer reduceMin= intList.stream().reduce(Integer::min).get();
        Integer reduceMax= intList.stream().reduce(Integer::max).get();
        Integer reduceSum = intList.stream().reduce(Integer::sum).get();
        System.out.println("Min reduce "+reduceMin +"Max reduce "+reduceMax+" Reduce sum "+reduceSum);


        //get sum of fee from student list

        Double totalFeeSum = studentList.stream().map(i->i.getFee()).reduce(Double::sum).get();
        System.out.println("Total fee "+totalFeeSum);

        //using summery static
        DoubleSummaryStatistics summaryStudentFee=studentList.stream().mapToDouble(Student::getFee).summaryStatistics();
        System.out.println("Fee summary"+summaryStudentFee);



    }



}
