package com.ybzbcq.thread;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }


    public BlockingQueue<BigInteger> get() {
        return this.queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            cancel();
        }
    }

    public void cancel() {
        interrupt();
    }

    public static void main(String[] args) {
        BlockingQueue<BigInteger> queue = new LinkedBlockingQueue();
        PrimeProducer pp = new PrimeProducer(queue);
        Thread thread = new Thread(pp);
        thread.start();

        try {
            SECONDS.sleep(1);
            pp.cancel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pp.cancel();
        }
        System.out.println(pp.get());

        System.out.println("worker Isinterrupted: "+ thread.isInterrupted());

        pp.cancel();

        System.out.println("worker Isinterrupted: "+ thread.isInterrupted());


    }
}
