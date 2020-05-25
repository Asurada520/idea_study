package com.ybzbcq.designpattern.observer;

public class Observer2 implements Observer {
    @Override  
    public void update(String message) {
        System.out.println("observer2 has received: " + message);
    }  
  
}  