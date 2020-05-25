package com.ybzbcq.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Demo02 implements Runnable{

    Lock lock =  new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get(){

        try {
            lock.lock();
            Thread thread = Thread.currentThread();
            System.out.println("[name:] " +thread.getName() + " [id:] " + thread.getId());
            set();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void set(){
        try {
            lock.lock();
            Thread thread = Thread.currentThread();
            System.out.println("[name:] " +thread.getName() + " [id:] " + thread.getId());
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class Test02 {

    public static void main(String[] args) {

        Demo02 demo = new Demo02();
        new Thread(demo, "demo1").start();
        new Thread(demo, "demo2").start();
        new Thread(demo, "demo3").start();

    }
}
