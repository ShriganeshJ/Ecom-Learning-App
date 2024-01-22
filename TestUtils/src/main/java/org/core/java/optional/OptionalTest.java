package org.core.java.optional;

import org.ecom.pojo.Employee;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {

        Employee employee = new Employee(10, "raja", 12000.00, "Des");

        /**
         * Optional.empty()
         * Optional.of()
         * Optional.ofNullable()
         */

        Optional<Employee> optionalEmpty = Optional.empty();
        Optional<Employee> optionalOf = Optional.of(employee);
        Optional<Employee> optionalOfNullable = Optional.ofNullable(employee);

        /**
         * isPresent()
         */
        if (optionalEmpty.isPresent()) {
            System.out.println("Using Empty class obj created " + optionalEmpty.get());
        }
        if (optionalOf.isPresent()) {
            System.out.println("Using Of class obj created " + optionalOf.get());
        }
        if (optionalOfNullable.isPresent()) {
            System.out.println("Using OfNullable class obj created " + optionalOfNullable.get());

        }
        /**
         *
         * orElse()
         */

        Optional<Employee> emp = Optional.of(employee);
        Optional<Employee> emptyOptional = Optional.empty();

        Optional<Employee> optionalEmployee = Optional.of(emptyOptional).orElseGet(()->emp);
        if(optionalEmployee.isPresent())
        System.out.println("OrElseUsingTest"+optionalEmployee.get());


    }
}
