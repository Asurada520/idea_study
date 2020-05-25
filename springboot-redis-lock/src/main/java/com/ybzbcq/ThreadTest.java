package com.ybzbcq;

import com.ybzbcq.service.LockService;

public class ThreadTest extends Thread {

    private LockService lockService;

    public ThreadTest(LockService lockService) {
        this.lockService = lockService;
    }

    public void run() {
        lockService.seckill();
    }
}
