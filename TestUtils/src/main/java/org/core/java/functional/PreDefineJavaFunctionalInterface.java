package org.core.java.functional;
import org.core.java.stream.Student;
import org.ecom.pojo.CurrencyTrade;
import org.ecom.pojo.TradeType;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PreDefineJavaFunctionalInterface {

    private static  List<Student> studentList;
    static {
        studentList  = List.of(
                new Student("raja","",10,10000,"MBA",4.69),
                new Student("raja","",10,10000,"DBA",10),
                new Student("mohan","",17,20000,"MBA",8.69),
                new Student("niti","",19,170000,"DBA",14),
                new Student("BOB","",16,16000,"MBA",9.32),
                new Student("rohan","",16,11000,"D",15),
                new Student("Jack","",15,12000,"D",17),
                new Student("azim","",16,13000,"MBA",8.36),
                new Student("prakash","",11,10000,"DBA",18),
                new Student("HOB","",24,10000,"BBA",14),
                new Student("TOM","",20,10000,"MBA",7.63)
        );
    }
    public static void main(String[] args) {


        /***
         * Example for pre define predicate interface
         *   find student department is DBA
         */

        Predicate<Student> isDBAStudent = (student -> student.getDepartment().equals("DBA"));
        List<Student> dbaStudentList = studentList.stream().filter(isDBAStudent).collect(Collectors.toList());

        System.out.println("DBA Student is :: " +dbaStudentList);

        /***
         * Example for BiPredicate pre define interface
         *   find student of MBA and Grade is > 8.0
         */
        BiPredicate<String,Double> isEligible = (department,grade) -> department.equals("MBA")&&grade>8.0;

      List<Student> placementList=studentList.stream().filter(s->isEligible.test(s.getDepartment(),s.getGrade())).collect(Collectors.toList());
        System.out.println("eligible students are "+placementList);


        /***
         * Example for pre define Functional interface
         * calculate the profit function
         */

        Function<CurrencyTrade,Double> calculateProfit = (c)->(c.getExitPrice()-c.getEntryPrice())*c.getLotSize();

        System.out.println("Total Profit is "+calculateProfit.apply(new CurrencyTrade("email",74,10.21,12.30,500, TradeType.FX,"EUR/USD")));

        /***
         * Example for pre define BiFunctional interface
         * calculate liquor and Food bill total
         */
        Integer liquorBill =1400;
        Integer foodBill=1500;
        BiFunction<Integer,Integer,Integer> foodBillSum =(l,f)->l+f;
        System.out.println("Food Bill Sum "+ foodBillSum.apply(liquorBill,foodBill));




    }
}
