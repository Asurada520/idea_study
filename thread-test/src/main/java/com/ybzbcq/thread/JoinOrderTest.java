package com.ybzbcq.thread;

/**
 * @author Administrator
 * @Description TODO
 * @since 2019-11-26 10:48
 */

public class JoinOrderTest {
    public static void main(String[] args) {

        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t1:" + i);
                }
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            public void run() {

                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < 10; i++) {
                    System.out.println("t2:" + i);
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {

            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println("t3:" + i);
                }
            }
        });


        t1.start();
        t2.start();
        t3.start();

    }
}