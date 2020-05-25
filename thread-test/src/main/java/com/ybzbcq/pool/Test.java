package com.ybzbcq.pool;

import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @Description CountDownLatch 应用 自动减去一
 * @since 2019-12-06 10:06
 */

public class Test {
    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {

            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " t1 子线程 开始 ");
                countDownLatch.countDown(); // 计数器值每次减去一
                System.out.println(threadName + " t1 子线程 结束");
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            public void run() {

                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " t2 子线程 开始 ");
                countDownLatch.countDown();// 计数器值每次减去一
                System.out.println(threadName + " t2 子线程 结束");

            }
        });

        t1.start();
        t2.start();

        countDownLatch.await();

        System.out.println("子线程 完毕 ... ");
        System.out.println("主线程 开始 ... ");
        for (int i = 0; i < 10; i++) {
            System.out.println("main i: " + i);
        }


    }
}