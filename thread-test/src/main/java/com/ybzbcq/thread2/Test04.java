package com.ybzbcq.thread2;

/**
 * @author Administrator
 * @Description volatile 关键字的使用
 * @since 2019-12-04 15:51
 */


class ThreadVolatile extends Thread {

    public volatile boolean flag = true;

    @Override
    public void run() {

        System.out.println("Child thread starting  ... ");
        while (flag){

        }
        System.out.println("Child thread stopped  ... ");
    }

    public void setFlag( boolean flag){
        this.flag = flag;
    }
}

public class Test04 {

    public static void main(String[] args) throws InterruptedException {

        ThreadVolatile threadVolatile = new ThreadVolatile();
        threadVolatile.start();
        Thread.sleep(3000);
        threadVolatile.setFlag(false);
        System.out.println("Flag updated: false");

        Thread.sleep(1000);

        System.out.println("Flag got:" + threadVolatile.flag);

    }

}