package com.jade.distributelock;

public class OrderService implements Runnable {

    private OrderIDGenerator orderIDGenerator = new OrderIDGenerator();

    private ExtLock lock = new ZKDistributeLock();

    @Override
    public void run() {
        try {
            lock.getLock();
            String id = orderIDGenerator.getID();
            System.out.println(Thread.currentThread().getName() + ", ID:" + id);
        } catch (Exception e){
//            e.printStackTrace();
        }finally {
            lock.unLock();
        }

    }

    /*@Override
    public synchronized void run() {
        String id = orderIDGenerator.getID();
        System.out.println(Thread.currentThread().getName() + ", ID:" + id);
    }*/


}
