package com.jade.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args) throws JMSException {

        // 获取连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
        // 创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        // 启动连接
        connection.start();
        // 创建工厂会话
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        // 创建队列
        Destination destination = session.createQueue("jade_queue");
        MessageConsumer consumer = session.createConsumer(destination);

        while (true){
            TextMessage textMessage = (TextMessage) consumer.receive();
            if(textMessage != null){
                String text = textMessage.getText();
                System.out.println("consumer: " + text);
            }else{
                break;
            }
        }

        System.out.println("consumer get message over!");

    }
}
