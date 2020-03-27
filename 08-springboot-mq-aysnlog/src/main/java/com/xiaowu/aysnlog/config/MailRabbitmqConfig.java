package com.xiaowu.aysnlog.config;

import com.xiaowu.aysnlog.common.rabbitmq.ExchangeEnum;
import com.xiaowu.aysnlog.common.rabbitmq.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.apache.commons.lang3.StringUtils;

@Configuration
@PropertySource(value = {"classpath:application.yaml"})
public class MailRabbitmqConfig {
    @Autowired
    private Environment env;

    @Bean
    Queue queue() {
//        String name = env.getProperty("mq.queue").trim();
        // 是否持久化
        boolean durable = StringUtils.isNotBlank(env.getProperty("mq.queue.durable").trim())?
                Boolean.valueOf(env.getProperty("mq.queue.durable").trim()) : true;
        // 仅创建者可以使用的私有队列，断开后自动删除
        boolean exclusive = StringUtils.isNotBlank(env.getProperty("mq.queue.exclusive").trim())?
                Boolean.valueOf(env.getProperty("mq.queue.exclusive").trim()) : false;
        // 当所有消费客户端连接断开后，是否自动删除队列
        boolean autoDelete = StringUtils.isNotBlank(env.getProperty("mq.queue.autoDelete").trim())?
                Boolean.valueOf(env.getProperty("mq.queue.autoDelete").trim()) : false;
        return new Queue(QueueEnum.AYSN_MAIL.getName(), durable, exclusive, autoDelete);
    }

    @Bean
    TopicExchange exchange() {
//        String name = env.getProperty("mq.exchange").trim();
        // 是否持久化
        boolean durable = StringUtils.isNotBlank(env.getProperty("mq.exchange.durable").trim())?
                Boolean.valueOf(env.getProperty("mq.exchange.durable").trim()) : true;
        // 当所有消费客户端连接断开后，是否自动删除队列
        boolean autoDelete = StringUtils.isNotBlank(env.getProperty("mq.exchange.autoDelete").trim())?
                Boolean.valueOf(env.getProperty("mq.exchange.autoDelete").trim()) : false;
        return new TopicExchange(ExchangeEnum.AYSN_MAIL.getValue(), durable, autoDelete);
    }

    @Bean
    Binding binding() {
//        String routekey = env.getProperty("mq.routekey").trim();
        return BindingBuilder.bind(queue()).to(exchange()).with(QueueEnum.AYSN_MAIL.getRoutingKey());
    }

//    @Bean
//    public SimpleMessageListenerContainer listenerContainer(
//            @Qualifier("mailMessageListenerAdapter") MailMessageListenerAdapter mailMessageListenerAdapter) throws Exception {
//        String queueName = env.getProperty("mq.queue").trim();
//
//        SimpleMessageListenerContainer simpleMessageListenerContainer =
//                new SimpleMessageListenerContainer(cachingConnectionFactory());
//        simpleMessageListenerContainer.setQueueNames(queueName);
//        simpleMessageListenerContainer.setMessageListener(mailMessageListenerAdapter);
//        // 设置手动 ACK
//        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        return simpleMessageListenerContainer;
//    }

}
