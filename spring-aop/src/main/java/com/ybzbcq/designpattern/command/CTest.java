package com.ybzbcq.designpattern.command;

public class CTest {
    public static void main(String[] args) {

        Receiver receiver = new Receiver();
        MyCommand myCommand = new MyCommand(receiver);
        Invoker invoker = new Invoker(myCommand);
        invoker.action("勇往直前，前进， come on ! ");

    }
}
