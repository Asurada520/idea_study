package com.jade.service;

import java.util.concurrent.atomic.AtomicInteger;


public class LimitService {

    // limit 60 times
    private int limitCount = 60;
    // 每秒钟实际请求的数量
    AtomicInteger atomicInteger = new AtomicInteger(0);
    private long start = System.currentTimeMillis();
    // 间隔时间60秒
    private int interval = 60;


    public boolean acquire() {

        long newTime = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (newTime > (start + interval)) {
            start = newTime;
            atomicInteger.set(0);
            return true;
        }
        atomicInteger.incrementAndGet();

        return atomicInteger.get() <= limitCount;
    }

}
