package org.core.java;

/**
 *
 * First extends and then implements
 *
 */
public class ClassHasMorePowerThanInterfaceTest extends ClassTest implements InterfaceTest
{
    static
    {
     ClassHasMorePowerThanInterfaceTest test = new ClassHasMorePowerThanInterfaceTest();
     test.show();
    }

    public static void main(String[] args) {
      System.out.println("Main Method ");
    }
}

class ClassTest
{
    public void show()
    {
        System.out.println("Class Power");
    }
}

interface InterfaceTest
{
    public default void show()
    {
        System.out.println("Interface Power");
    }
}

