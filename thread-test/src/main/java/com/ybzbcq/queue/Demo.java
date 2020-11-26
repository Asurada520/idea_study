package com.ybzbcq.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @Description  非阻塞式队列
 * @since 2019-12-10 14:48
 */

public class Demo {

    public static void main(String[] args) throws InterruptedException {

//        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
//
//        concurrentLinkedQueue.offer("天道");
//        concurrentLinkedQueue.offer("不仁");
//        concurrentLinkedQueue.offer("万物");
//        concurrentLinkedQueue.offer("刍狗");
//
//        System.out.println(concurrentLinkedQueue.poll());
//        System.out.println(concurrentLinkedQueue.peek());
//        System.out.println(concurrentLinkedQueue.poll());
//        System.out.println(concurrentLinkedQueue.peek());
//
//        System.out.println(concurrentLinkedQueue.size());


        ArrayBlockingQueue<String> arrays  = new ArrayBlockingQueue<>(3);

        arrays.add("tqq1");
        arrays.add("tqq2");
        arrays.add("tqq3");
        arrays.offer("tqq4",3, TimeUnit.SECONDS);


        String peek = arrays.poll();
        String peek2 = arrays.poll();
        String peek3 = arrays.poll();
        String peek4 = arrays.poll();

        System.out.println(peek);
        System.out.println(peek2);
        System.out.println(peek3);
        System.out.println(peek4);

    }
}