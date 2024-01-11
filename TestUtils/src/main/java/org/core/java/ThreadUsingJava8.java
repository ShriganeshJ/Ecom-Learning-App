package org.core.java;
/**
 *
 *
 * In that class we create thread using anyInner class
 * Using java 8 Lambda
 * Using inner class disadvantage is it create additional instance for innerClass
 */
public class ThreadUsingJava8 extends Thread {

    public static void main(String[] args) {
        System.out.println("Main Method Thread id"+Thread.currentThread().getId());
        /**
         *
         * Using traditional approach-1
         */
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Using Inner class Thread id is"+Thread.currentThread().getId());
            }
        });
        t.start();


        /**
         *
         * Using Lambda Expression
         *
         */

        Thread t3 = new Thread(()-> System.out.println("Using Lambda Thread id is "+Thread.currentThread().getId()));
        t3.start();


    }





}
