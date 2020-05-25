package com.ybzbcq.future;

public class ColdDish extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(" 冷菜准备完毕 ... ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
