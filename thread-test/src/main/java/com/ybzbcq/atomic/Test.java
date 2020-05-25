package com.ybzbcq.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * @Description 原子类 测试
 * @since 2019-12-18 10:29
 */


class Demo implements Runnable {

    private Integer count = 1;

    private AtomicInteger atomic = new AtomicInteger();

    @Override
    public void run() {

        while (true) {
//            int count = getCount();
            int count = getAtomic();
            System.out.println(count);
            if (count > 50) {
                break;
            }
        }

    }

    public synchronized Integer getCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return count++;
    }

    public int getAtomic(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return atomic.incrementAndGet();
    }
}

public class Test {

    public static void main(String[] args) {

        Demo demo = new Demo();

        new Thread(demo).start();
        new Thread(demo).start();


    }
}