package com.jade.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
public class QueueConfig {

    @Value("${queue}")
    private String queue;
    @Bean
    public Queue logQueue() {
        return new ActiveMQQueue(queue);
    }
    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory, Queue queue) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDeliveryMode(2); // 持久化配置 1-非持久化 2-持久化
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
        jmsTemplate.setDefaultDestination(queue);// 此处可不设置默认，在发送消息时也可设置队列
        jmsTemplate.setSessionAcknowledgeMode(4); // 客户端签收方式
        return jmsTemplate;
    }

    // 定义一个消息监听器连接工厂，这里定义的是点对点模式的监听器连接工厂
    @Bean(name = "jmsQueueListener")
    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory(
            ActiveMQConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory);
        // 设置连接数
        factory.setConcurrency("1-10");
        // 重连间隔时间
        factory.setRecoveryInterval(1000L);
        factory.setSessionAcknowledgeMode(4);
        return factory;
    }
}
