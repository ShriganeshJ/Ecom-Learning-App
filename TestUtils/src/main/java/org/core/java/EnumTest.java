package org.core.java;

public class EnumTest {
    public static void main(String[] args) {
        UPDATE_TYPE updateType = UPDATE_TYPE.valueOf("EMAIL");
        System.out.println("User is " + updateType.name());


    }
}
