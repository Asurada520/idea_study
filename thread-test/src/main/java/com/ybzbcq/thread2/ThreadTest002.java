package com.ybzbcq.thread2;

/**
 * @author Administrator
 * @Description 多线程间 通讯  wait notify 应用
 * @since 2019-12-05 17:22
 */


class Resp {
    public String name;
    public String gender;

    // true  读,不可以写  false 不可以读,写
    public boolean flag = false;
}

class AddThread extends Thread {

    private Resp res;

    public AddThread(Resp res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (res) {

                try {
                    if (res.flag) {
                        res.wait();
                        // Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (count == 0) {
                    res.name = "黄仙";
                    res.gender = "女";
                } else if (count == 1) {
                    res.name = "李牧";
                    res.gender = "男";
                }
                res.flag = true;
                res.notify();
            }
            count = (count + 1) % 2;


        }
    }

}

class ReadThread extends Thread {
    private Resp res;

    public ReadThread(Resp res) {
        this.res = res;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (res) {

                try {
                    if (!res.flag) {
                        res.wait();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(res.name + " " + res.gender);
                res.flag = false;
                res.notify();
            }
        }

    }
}


public class ThreadTest002 {
    public static void main(String[] args) {
        Resp res = new Resp();
        AddThread addThread = new AddThread(res);
        ReadThread readThread = new ReadThread(res);
        addThread.start();
        readThread.start();

    }
}