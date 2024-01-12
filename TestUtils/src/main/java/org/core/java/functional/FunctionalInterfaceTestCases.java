package org.core.java.functional;

/**
 *
 * Function interfaces has only one Single Abstract Method
 * But allow multiple def and static method
 */
@FunctionalInterface
interface  SumCalculator
{
    //SAM
    public void add(int i);
    //Default we can't use private for default
    public default void intSum(int i){}
    //Static method java9 private
   private static void floatSum(float i){}

}

/**
 * Can we extend Function interface to another interface
 *
 */
@FunctionalInterface
interface Pcalculator extends SumCalculator
{
    //if we can add new SAM then it's not functional Interface

}

@FunctionalInterface
interface Tcalculator
{
    public abstract void add(int i);
}


/**
 *
 * If parent method of two interface
 * Has same signature,returnType and Argument
 */

public class FunctionalInterfaceTestCases implements SumCalculator,Tcalculator  {


    @Override
    public void add(int i) {
   SumCalculator testCases = new FunctionalInterfaceTestCases();
   Tcalculator testCase2 = new FunctionalInterfaceTestCases();
   System.out.println("MyParent is"+testCases.getClass().getName());
   System.out.println("MyParent is"+testCases.getClass().getSuperclass().getName());

    }

    public static void main(String[] args) {
        FunctionalInterfaceTestCases testCases = new FunctionalInterfaceTestCases();
        testCases.add(10);

    }
}
