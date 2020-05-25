package com.ybzbcq.designpattern.facade;

public class User {
    public static void main(String[] args) throws InterruptedException {

        Computer computer = new Computer();
        computer.startup();

        System.out.println();
        System.out.println("The computer is closed after one second");
        Thread.sleep(1000);
        System.out.println();

        computer.shutdown();


    }
}
