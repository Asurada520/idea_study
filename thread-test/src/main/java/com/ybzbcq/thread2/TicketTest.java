package com.ybzbcq.thread2;

/**
 * @author 李亚
 * @Description 多线程 死锁情况测试  synchronized 不用用错，锁必须是同一个，尽量是同步代码块 就好
 * @since 2019-12-02 17:23
 */
class Note implements Runnable {

    /**
     * 车票
     */
    private int number = 100;

    private Object obj = new Object();

    public boolean flag = true;


    @Override
    public void run() {

        if (flag) {
            while (number > 0) {
                synchronized (obj) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (number > 0) {
                        int temp = 100 - number + 1;
                        if (temp < 10) {
                            System.out.println(Thread.currentThread().getName() + " 出售 0" + (100 - number + 1) + " 张票");
                        } else {
                            System.out.println(Thread.currentThread().getName() + " 出售 " + (100 - number + 1) + " 张票");
                        }
                        number--;
                    }
                }
            }
        } else {
            while (number > 0) {

                sale();
            }
        }

    }

    public synchronized void sale() {
        //synchronized (obj) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (number > 0) {
                int temp = 100 - number + 1;
                if (temp < 10) {
                    System.out.println(Thread.currentThread().getName() + " 出售 0" + (100 - number + 1) + " 张票");
                } else {
                    System.out.println(Thread.currentThread().getName() + " 出售 " + (100 - number + 1) + " 张票");
                }
                number--;
            }
        //}
    }
}

public class TicketTest {

    public static void main(String[] args) throws InterruptedException {

        Note note = new Note();

        Thread t1 = new Thread(note, "window1:");
        Thread t2 = new Thread(note, "window2:");

        t1.start();
        Thread.sleep(40);
        note.flag =false;
        t2.start();

    }
}