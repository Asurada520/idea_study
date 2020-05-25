package com.ybzbcq.thread;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CancelVolatile implements Runnable{

    private final List<BigInteger> pri = new ArrayList<BigInteger>();

    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                pri.add(p);
            }
        }
    }

    private void cancel() {
        cancelled = true;
    }

    private synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(pri);
    }

    public static void main(String[] args) {
        CancelVolatile cancelVolatile = new CancelVolatile();
        new Thread(cancelVolatile).start();
        try {
            SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            cancelVolatile.cancel();
        }
        System.out.println(cancelVolatile.get());
    }

}
