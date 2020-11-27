package com.ybzbcq.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();


        Callable ca1 = new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "凉菜准备完成 ... ";
            }
        };

        FutureTask<String> ft1 = new FutureTask<String>( ca1);
        new Thread(ft1).start();


        Callable ca2 = new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3*1000);
                return "包子准备完成 ...";
            }
        };

        FutureTask<String> ft2 = new FutureTask<String>(ca2);
        new Thread(ft2).start();

        System.out.println(ft1.get());
        System.out.println(ft2.get());

        long end = System.currentTimeMillis();

        System.out.println("食物准备完成，需时：" + (end - start));

    }
}
