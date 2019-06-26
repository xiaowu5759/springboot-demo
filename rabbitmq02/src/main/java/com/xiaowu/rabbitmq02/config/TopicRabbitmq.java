package com.xiaowu.rabbitmq02.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitmq {

    // 先创建两个队列
    @Bean
    public Queue topicQueueA(){
        return new Queue("topic.message");
    }

    @Bean
    public Queue topicQueueB(){
        return new Queue("topic.messages");
    }

    // 配置topic交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    // 给队列绑定exchange和routing_key
    @Bean
    public Binding bindingExchangeMessage(Queue topicQueueA,TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueueA).to(topicExchange).with("topic.message");
    }

    @Bean
    public Binding bindingExchangeMessages(Queue topicQueueB,TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueueB).to(topicExchange).with("topic.#");
    }
}
