package com.jade.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer02 {
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

        MessageProducer producer = session.createProducer(null);
        // 不持久化
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for (int i = 1; i <= 5; i++) {
            System.out.println("我是生产者: " + i);
            sendMsg(session, producer, "我是生产者: " + i);

        }
        System.out.println("生产者 发送消息完毕!!!");

    }

    public static void sendMsg(Session session, MessageProducer producer, String i) throws JMSException {
        TextMessage textMessage = session.createTextMessage("hello activemq " + i);
        Destination destination = session.createTopic("jade-topic");
        producer.send(destination,textMessage);
    }
}
