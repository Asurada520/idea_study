package com.ybzbcq.pool;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author Administrator
 * @Description (计数信号量)Semaphore 应用：一个基于计数的信号量
 * 设置许可信号数量，超过阀值后，线程申请 许可信号 会被阻塞
 * @since 2019-12-06 17:16
 */

class Sign extends Thread {
    private String name;
    private Semaphore semaphore;

    public Sign(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        int availablePermits = semaphore.availablePermits();

        if (availablePermits > 0) {
            System.out.println(name + " 天助我也，终于有茅坑了 ... ");
        }else{
            System.out.println(name + " 怎么没有茅坑了 ... ");
        }

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + "终于上厕所啦.爽啊" + ",剩下厕所:" + semaphore.availablePermits());

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(name + "厕所上完啦!");
        // 释放资源
        semaphore.release();


    }
}

public class Test3 {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 10; i++) {
            Sign thradDemo001 = new Sign("第" + i + "个人", semaphore);
            thradDemo001.start();
        }
    }


}