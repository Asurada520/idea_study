package com.ybzbcq.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @Description 线程池 测试
 * @since 2019-12-12 14:39
 */

public class ThreadPoolTest {
    public static void main(String[] args) {

        // 可缓存线程池 无限制 线程个数
        /*ExecutorService executors = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int temp = i;
            executors.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "--> ] 第一次 线程池测试:]0" + temp);
                }
            });
        }

        executors.shutdown();*/

        // 固定长度 控制线程 最大并发数 超过放入队列
        /*ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "--> ] 第一次 线程池测试:]0" + temp);
                }
            });
        }

        executorService.shutdown();*/

        /*ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            scheduledExecutorService.schedule(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "--> ] 第一次 线程池测试:]0" + temp);
                }
            },3, TimeUnit.SECONDS);
        }

        scheduledExecutorService.shutdown();*/

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " --> ] 第一次 线程池测试:]0" + temp);
                }
            });
        }

        executorService.shutdown();


    }
}