package com.ybzbcq.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Administrator
 * @Description  非阻塞式队列
 * @since 2019-12-10 14:48
 */

public class Demo {

    public static void main(String[] args) {

        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

        concurrentLinkedQueue.offer("天道");
        concurrentLinkedQueue.offer("不仁");
        concurrentLinkedQueue.offer("万物");
        concurrentLinkedQueue.offer("刍狗");

        System.out.println(concurrentLinkedQueue.poll());
        System.out.println(concurrentLinkedQueue.peek());
        System.out.println(concurrentLinkedQueue.poll());
        System.out.println(concurrentLinkedQueue.peek());

        System.out.println(concurrentLinkedQueue.size());

    }
}