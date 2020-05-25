package com.ybzbcq.thread;

/**
 * @author Administrator
 * @Description 测试 volatile 线程之间的可见性
 * @since 2019-11-27 10:45
 */

public class ThreadVolatileDemo extends Thread{

    public volatile boolean flag = true;


    @Override
    public void run() {
        System.out.println(" 子线程 开始 ... ");

        while(flag){

        }

        System.out.println(" 子线程 结束 ... ");
    }

    public void setRunning(boolean flag){
        this.flag = flag;
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();
        threadVolatileDemo.start();
        Thread.sleep(3000);
        threadVolatileDemo.setRunning(false);
        System.out.println("flag 已经设置成false");
        Thread.sleep(1000);
        System.out.println(threadVolatileDemo.flag);


    }
}