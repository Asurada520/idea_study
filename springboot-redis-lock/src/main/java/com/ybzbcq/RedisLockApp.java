package com.ybzbcq;

import com.ybzbcq.service.LockService;

public class RedisLockApp {

    public static void main(String[] args) {

        LockService lockService = new LockService();

        for (int i = 0; i < 100; i++) {
            new ThreadTest(lockService).start();
        }

    }
}
