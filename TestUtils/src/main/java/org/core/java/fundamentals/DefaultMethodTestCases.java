package org.core.java.fundamentals;

/**
 *
 *
 * we can't declare this method as abstract method
 * We can't override Obj class method as default method
 */
interface Calculator
{

    //this method should have body
    public default void abc(){}
    //here will get compile time error

    /*public default boolean equals(Object obj){}*/

}

/**
 *
 * while override default method in sub class
 * access specifier should be public else will get compile time error
 */

public class DefaultMethodTestCases implements Calculator {

   public void abc()
    {

    }
}
