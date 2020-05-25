package com.ybzbcq.pool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Administrator
 * @Description CyclicBarrier 应用： 等待所有线程都到达后，唤醒
 * @since 2019-12-06 10:29
 */

class Writer extends Thread{

    private CyclicBarrier cyclicBarrier;

    public Writer(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println("[线程 -> ]" + threadName + ", 正在写入数据 ... ");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[线程 -> ]" + threadName + ", 写入数据成功 ... ");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("[所有线程执行完毕 <- ]");

    }
}

public class Test2 {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        for (int i = 0; i < 5; i++) {
            Writer writer = new Writer(cyclicBarrier);
            writer.start();
        }


    }
}