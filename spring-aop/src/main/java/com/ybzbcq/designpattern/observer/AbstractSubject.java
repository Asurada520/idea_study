package com.ybzbcq.designpattern.observer;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public abstract class AbstractSubject implements Subject {
  
    private Vector<Observer> vector2 = new Vector<Observer>();

    private List<Observer> vector = new ArrayList<>();
    @Override  
    public void add(Observer observer) {  
        vector.add(observer);  
    }  
  
    @Override  
    public void del(Observer observer) {  
        vector.remove(observer);  
    }  

    /* 通知方法 通知所有观察者 */
    @Override  
    public void notifyObservers( String message ) {
       /* Enumeration<Observer> enumo = vector.elements();
        while(enumo.hasMoreElements()){  
            enumo.nextElement().update(message);
        }*/

       if(!CollectionUtils.isEmpty(vector)){
           for (Observer observer: vector) {
               observer.update(message);
           }
       }else{
           System.out.println("无观察者");
       }
    }  
}