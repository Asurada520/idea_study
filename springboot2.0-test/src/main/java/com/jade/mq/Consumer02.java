package com.jade.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer02 {

    public static void main(String[] args) throws JMSException {

        System.out.println("consumer 03 :  ");

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
        Destination destination = session.createTopic("jade-topic");
        MessageConsumer createConsumer = session.createConsumer(destination);
        while (true) {
            // 监听消息
            TextMessage textMessage = (TextMessage) createConsumer.receive();
            if (textMessage != null) {
                String text = textMessage.getText();
                System.out.println("消费者 获取到消息:  text:" + text);

            } else {
                break;
            }
        }

        System.out.println("消费者消费消息完毕!!!");

    }
}
