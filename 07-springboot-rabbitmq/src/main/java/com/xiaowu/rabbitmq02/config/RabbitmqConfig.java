package com.xiaowu.rabbitmq02.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Rabbitmq 配置类
 */
@Configuration
public class RabbitmqConfig {
//    @Autowired
//    private Environment env;

//    @Bean
//    public Queue queue(){
//        boolean durable = true;
//        boolean exclusive = false;
//        boolean autoDelete = false;
//        return new Queue(env.getProperty("queue"), durable, exclusive, autoDelete);
//    }
//
//    @Bean
//    public DirectExchange defaultExchange() {
//        boolean durable = true;
//        boolean autoDelete = false;
//        return new DirectExchange(env.getProperty("defaultExchange"), durable, autoDelete);
//    }
//
//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(queue())
//                .to(defaultExchange())
//                .with(env.getProperty("routeKey"));
//    }

    @Bean
    public Queue queue(){
        return new Queue("hello");
    }

    @Bean
    public Queue queue2(){
        return new Queue("hello2");
    }




}
