package com.ybzbcq.lock;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @Description ReentrantLook 重入锁测试
 * @since 2019-12-17 16:02
 */
class Demo2 implements Runnable{

    ReentrantLock look = new ReentrantLock();

    public void get(){

        try {
            look.lock();
            System.out.println("[name:] " + Thread.currentThread().getName() + " get();");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            look.unlock();
        }


    }

    public void set(){

        try {
            look.lock();
            System.out.println("[name:] " + Thread.currentThread().getName() + " set();");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            look.unlock();
        }

    }



    @Override
    public void run() {
        get();
    }
}
public class Test2 {
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        new Thread(demo2).start();
        new Thread(demo2).start();
        new Thread(demo2).start();
        new Thread(demo2).start();
    }
}