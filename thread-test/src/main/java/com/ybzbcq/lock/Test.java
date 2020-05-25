package com.ybzbcq.lock;

/**
 * @author Administrator
 * @Description synchronized 重入锁测试
 * @since 2019-12-17 15:57
 */

class Demo implements Runnable{

    public synchronized void get(){
        System.out.println("[name:] " + Thread.currentThread().getName() + " get();");
        set();
    }
    public synchronized void set(){
        System.out.println("[name:] " + Thread.currentThread().getName() + " set();");
    }

    @Override
    public void run() {
        get();
    }
}

public class Test {
    public static void main(String[] args) {
        Demo demo = new Demo();

        new Thread(demo).start();
        new Thread(demo).start();
        new Thread(demo).start();
        new Thread(demo).start();
        new Thread(demo).start();

    }
}