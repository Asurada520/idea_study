package com.ybzbcq.pool;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            Wc wc = new Wc(semaphore, "第" + i + "个人");
            wc.start();
        }

    }
}


class Wc extends Thread {

    private String name;

    private Semaphore sp;

    public Wc(Semaphore sp, String name) {
        this.sp = sp;
        this.name = name;
    }

    @Override
    public void run() {

        int permits = sp.availablePermits();
        if (permits > 0) {
            System.out.println(name + ", 正常如厕");
        } else {
            System.out.println(name + ", 貌似要等了，天哪！");
        }

        try {
            sp.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + ", 正常如厕, 余下：" + sp.availablePermits());

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + ", 如厕结束");

        sp.release();

    }
}
