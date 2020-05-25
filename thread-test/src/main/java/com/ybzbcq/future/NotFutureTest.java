package com.ybzbcq.future;

public class NotFutureTest {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        Thread t1 = new ColdDish();
        t1.start();
        t1.join();

        Thread t2 = new BumThread();
        t2.start();
        t2.join();

        long end = System.currentTimeMillis();
        System.out.println("ready completed time : " + (end - start));

    }
}
