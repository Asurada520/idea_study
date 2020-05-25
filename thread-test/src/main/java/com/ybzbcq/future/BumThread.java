package com.ybzbcq.future;

public class BumThread  extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(3*1000);
            System.out.println(" 包子准备完毕 ...");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
