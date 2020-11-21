package com.jade.task;

/**
 *
 *  定时任务 测试
 */
public class Demo1 {

    private static int count = 0;

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("次数：" + count++);
                    if(count>10){
                        break;
                    }
                }

            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
