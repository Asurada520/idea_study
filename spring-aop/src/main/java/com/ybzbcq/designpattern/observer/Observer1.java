package com.ybzbcq.designpattern.observer;

public class Observer1 implements Observer {
    @Override  
    public void update(String message) {
        System.out.println("observer1 has received: " + message);
    }  
}  