package org.core.java.lambda;

import java.util.function.BiPredicate;

/**
 *
 * In that class we test lambda expression using custom
 * functional interface and pre define functional interface
 */
public class LambdaExpressionTest {

    public static void main(String[] args) {

        //using custom interface
        PasswordAPI passwordAPI =(u,p)->u.toLowerCase().equals("admin")&&p.toLowerCase().equals("admin123");
        System.out.println("User Name and Password are "+passwordAPI.sendCred("admin","admin123"));
        System.out.println("User Name and Password are "+passwordAPI.sendCred("Admin","admin1239"));

        //using Bi predicate
        BiPredicate<String,String> biPredicate = (u, p) -> u.toLowerCase().equals("admin")&&p.toLowerCase().equals("admin123");
        System.out.println("User Name and Password are "+biPredicate.test("admin","admin123"));
        System.out.println("User Name and Password are "+biPredicate.test("Admin","admin123b9"));


    }
}
