package com.ybzbcq.thread;

/**
 * @author Administrator
 * @Description TODO
 * @since 2019-11-26 10:14
 */

public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread thread = Thread.currentThread();

                    System.out.println(thread.getName() + " " + thread.getId() + " " + thread.isAlive());
                }
            }
        });

        thread.start();

        thread.join();

        System.out.println(thread.isAlive());

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
            System.out.println("main" + " i:" + i);
        }


    }
}