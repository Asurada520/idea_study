package com.ybzbcq.thread;

/**
 * @author Administrator
 * @Description TODO
 * @since 2019-11-26 10:39
 */

public class ThreadPriorityTest implements Runnable{
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().toString() +" ---i:" + i);
        }
    }

    public static void main(String[] args) {

        ThreadPriorityTest thread = new ThreadPriorityTest();

        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);

        t1.start();

        t1.setPriority(10);

        t2.start();


    }
}