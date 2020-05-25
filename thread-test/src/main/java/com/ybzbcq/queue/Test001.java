package com.ybzbcq.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * @Description 使用BlockingQueue模拟生产者与消费者
 * @since 2019-12-11 14:13
 */

class ProducerThread implements Runnable {

    private BlockingQueue<String> blockingQueue;

    private AtomicInteger count = new AtomicInteger();

    private volatile boolean flag = true;

    public ProducerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {

        String threadName = Thread.currentThread().getName();
        try {
            while (flag) {
                System.out.println("< --------------------------------------- >");
                System.out.println(threadName + "--> ] 生产者开始启动 ... ");
                String data = count.incrementAndGet() + "";

                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println(threadName + "--> ], 生产队列 " + data + " 成功");
                } else {
                    System.out.println(threadName + "--> ], 生产队列 " + data + " 失败");
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(threadName + " 生产者线程停止 ... ");
        }

    }

    public void stop() {
        this.flag = false;
    }
}

class ConsumerThread implements Runnable {

    private BlockingQueue<String> blockingQueue;

    private boolean flag = true;

    public ConsumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {

        String threadName = Thread.currentThread().getName();

        try {
            System.out.println(threadName + "<-- ], 消费者开始启动 ... ");
            while (flag) {
                String data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (data == null) {
                    flag = false;
                    return;
                }

                System.out.println(threadName + "<-- ] 消费者获取队列消息成功，data: " + data);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(threadName + "<-- ], 消费者线程获取消息结束 ... ");
        }


    }
}

public class Test001 {

    public static void main(String[] args) {

        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(3);
        ProducerThread producerThread = new ProducerThread(blockingQueue);
        ConsumerThread consumerThread = new ConsumerThread(blockingQueue);

        Thread t1 = new Thread(producerThread, "Producer");
        Thread t2 = new Thread(consumerThread, "Consumer");

        t1.start();
        t2.start();

        try {
            Thread.sleep(10 * 1000);
            producerThread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}