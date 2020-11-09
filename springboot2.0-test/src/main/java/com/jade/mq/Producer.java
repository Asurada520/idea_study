package com.jade.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {

    public static void main(String[] args) throws JMSException {

        // 获取连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
        // 创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        // 启动连接
        connection.start();
        // 创建工厂会话 参数：1.是否事务提交    2.自动签收
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        // 创建队列
        Destination destination = session.createQueue("jade_queue");
        MessageProducer producer = session.createProducer(destination);
        // 不持久化
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for (int i = 1; i <= 5; i++) {
            System.out.println("我是生产者: " + i);
            sendMsg(session, producer, "我是生产者: " + i);

        }

        System.out.println("producer send message over！");
    }

    public static void sendMsg(Session session, MessageProducer producer, String i) throws JMSException {
        TextMessage textMessage = session.createTextMessage("hello activemq " + i);
        producer.send(textMessage);
    }

}
