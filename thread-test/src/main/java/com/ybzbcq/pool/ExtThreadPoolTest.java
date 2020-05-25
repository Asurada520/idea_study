package com.ybzbcq.pool;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @Description 自定义 线程池 测试
 * @since 2019-12-13 15:03
 */

public class ExtThreadPoolTest {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(3));


        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(new ThreadTest(i+""));
        }

        threadPoolExecutor.shutdown();


    }

}

class ThreadTest implements Runnable{

    private String taskName;

    public ThreadTest(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + taskName);
    }
}