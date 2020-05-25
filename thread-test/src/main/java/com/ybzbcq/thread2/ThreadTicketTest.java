package com.ybzbcq.thread2;

/**
 * @author Administrator
 * @Description TODO
 * @since 2019-12-02 16:49
 */

class Ticket implements Runnable {

    private int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    public synchronized void sale() {
        if (count > 0){
            int temp = 100 - count + 1;
            if(temp <10){
                System.out.println(Thread.currentThread().getName() + " 出售 0" + (100 - count + 1) + " 张票");
            }else{
                System.out.println(Thread.currentThread().getName() + " 出售 " + (100 - count + 1) + " 张票");
            }

            count--;
        }
    }
}

public class ThreadTicketTest {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket, "window1:");
        Thread t2 = new Thread(ticket, "window2:");

        t1.start();
        t2.start();
    }
}