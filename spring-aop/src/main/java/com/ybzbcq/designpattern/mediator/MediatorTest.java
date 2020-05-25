package com.ybzbcq.designpattern.mediator;

public class MediatorTest {
    public static void main(String[] args) {

        MyMediator myMediator = new MyMediator();
        myMediator.createMediator();
        myMediator.workAll();

    }
}
