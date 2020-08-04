package com.jade.test;

import com.jade.service.LimitService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * atomicInteger 原子类测试  限流
 */
public class Test {
    public static void main(String[] args) {

        LimitService limitService = new LimitService();

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 1; i < 100; i++) {
            int tempI = i;
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    if (limitService.acquire()) {
                        System.out.println("你没有被限流,可以正常访问逻辑 i:" + tempI);
                    }else{
                        System.out.println("你已经被限流呢  i:" + tempI);
                    }
                }
            });

        }


    }

}
