package com.ybzbcq.designpattern.observer;

public class MySubject extends AbstractSubject {
    @Override  
    public void operation(String message) {
        System.out.println("update self!");  
        notifyObservers(message);
    }  
  
}  