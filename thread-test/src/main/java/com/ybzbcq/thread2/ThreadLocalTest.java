package com.ybzbcq.thread2;

/**
 * @author Administrator
 * @Description ThreadLocal 不共享变量， 线程之间的数据隔离
 * @since 2019-12-03 17:21
 */

class Res {
//    public static Integer count = 0;

    public ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer getNum() {

        int count = threadLocal.get() + 1;
        threadLocal.set(count);

        return count;
    }

}

class ThreadDemo extends Thread {

    private Res res;

    public ThreadDemo(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "," + res.getNum());
        }
    }
}

public class ThreadLocalTest {

    public static void main(String[] args) {
        Res res = new Res();
        ThreadDemo t1 = new ThreadDemo(res);
        ThreadDemo t2 = new ThreadDemo(res);

        t1.start();
        t2.start();
    }
}