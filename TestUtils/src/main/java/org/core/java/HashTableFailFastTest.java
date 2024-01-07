package org.core.java;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableFailFastTest {

    public static void main(String[] args) {
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("abc","xxx");hashtable.put("wxy","abcd");
        hashtable.put("wxyh","abcjd");hashtable.put("wxyr","abckd");

        Enumeration<String> it = hashtable.elements();

        while (it.hasMoreElements())
        {
            hashtable.put("RRabc","with enumeration it fail safe");
            System.out.println(it.nextElement());
            System.out.println();
        }
        System.out.println("---------for each-------");
        hashtable.forEach((s, s2) ->

                System.out.println("key::"+s +"  "+"value::"+s2)


        );



    }
}
