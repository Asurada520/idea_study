package com.jade.task;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "${queue}")
    public void receiver(String message){
        System.out.println("消费者收到的消息是：" + message);
    }
}
