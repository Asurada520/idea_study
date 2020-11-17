package com.jade.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

//@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 3000)
    public void send() {
        String result = "测试消息 --- " + System.currentTimeMillis();
        System.out.println("result: " + result);
        jmsMessagingTemplate.convertAndSend(queue,result);
    }

}
