package com.ybzbcq.designpattern.command;

public class Receiver {
    public void action(String command){
        System.out.println(" Command had received : " + command);
    }
}
