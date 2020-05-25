package com.ybzbcq.thread2;

/**
 * @author Administrator
 * @Description 多线程间通讯
 * @since 2019-12-05 16:44
 */

class Response {
    public String name;
    public String gender;
}

class InThread extends Thread {

    private Response res;

    public InThread(Response res) {
        this.res = res;
    }

    @Override
    public void run() {

        int count = 0;
        while (true) {
            synchronized (res){
                if (count == 0) {
                    res.name = "黄仙";
                    res.gender = "女";
                } else if (count == 1) {
                    res.name = "李牧";
                    res.gender = "男";
                }
            }
            count = (count + 1) % 2;
        }
    }
}

class OutThread extends Thread {

    private Response res;

    public OutThread(Response res) {
        this.res = res;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (res){
                System.out.println(res.name +" "+ res.gender);
            }
        }

    }
}

public class ThreadTest001 {

    public static void main(String[] args) {
        Response res = new Response();
        InThread inThread = new InThread(res);
        OutThread outThread = new OutThread(res);
        inThread.start();
        outThread.start();
    }
}