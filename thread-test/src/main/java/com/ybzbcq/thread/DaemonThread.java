package com.ybzbcq.thread;

/**
 * @author Administrator
 * @Description TODO
 * @since 2019-11-25 16:57
 */

public class DaemonThread{
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是子进程 ... ");
                }
            }
        });

        thread.setDaemon(true);

        thread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
            System.out.println("我是主线程");
        }
        System.out.println("主线程执行完毕!");


    }
}