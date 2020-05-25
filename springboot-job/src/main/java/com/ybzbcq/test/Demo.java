package com.ybzbcq.test;

public class Demo {

    private static long count = 0;
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    System.out.println(count);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        try {
            thread.sleep(10*1000);
            thread.stop();
        } catch (InterruptedException e) {
            thread.stop();
            e.printStackTrace();
        }
    }
}
