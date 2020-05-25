package com.ybzbcq.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            public void run() {
            // task to run  here
                System.out.println("hello");
            }
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(runnable,1,1, SECONDS);

        Thread.sleep(10*1000);
        scheduledExecutorService.shutdown();
    }
}
