package com.jade.distributelock;

public class LockTest {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            OrderService orderService = new OrderService();
            new Thread(orderService).start();
        }


    }
}
