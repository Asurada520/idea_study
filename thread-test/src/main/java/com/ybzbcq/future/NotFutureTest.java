package com.ybzbcq.future;

/**
 *
 *  准备信息 加入 执行 流程
 *
 *  计算 整体执行完成 需要的时间
 *
 */
public class NotFutureTest {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        Thread t1 = new ColdDish();
        t1.start();
        t1.join(); // 加入 执行 流程

        Thread t2 = new BumThread();
        t2.start();
        t2.join(); // 加入 执行 流程

        long end = System.currentTimeMillis();

        System.out.println("准备完成需要的时间：" + (end - start));


    }
}
