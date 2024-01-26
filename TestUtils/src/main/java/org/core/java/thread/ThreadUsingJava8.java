package org.core.java.thread;

/**
 * In that class we create thread using anyInner class
 * Using java 8 Lambda
 * Using inner class disadvantage is it create additional instance for innerClass
 */
public class ThreadUsingJava8 extends Thread {
    /**
     *
     * Using extend Thread class
     */
    @Override
    public void run() {
        System.out.println("Thread Using Extend " + Thread.currentThread().getId());

    }

    static {
        ThreadUsingJava8 t = new ThreadUsingJava8();
        t.start();

    }

    public static void main(String[] args) {
        System.out.println("Main Method Thread id " + Thread.currentThread().getId());
        /**
         *
         * Using traditional approach-1
         */
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Using Inner class Thread id is " + Thread.currentThread().getId());
            }
        });
        t.start();


        /**
         *
         * Using Lambda Expression
         *
         */

        Thread t3 = new Thread(() -> System.out.println("Using Lambda Thread id is " + Thread.currentThread().getId()));
        t3.start();


    }


}
