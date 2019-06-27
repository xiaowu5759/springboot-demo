package com.xiaowu.aysnlog.config;

import com.xiaowu.aysnlog.common.rabbitmq.ExchangeEnum;
import com.xiaowu.aysnlog.common.rabbitmq.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    @Bean
    public Queue logUserLoginQueue(){
        return new Queue(QueueEnum.USER_LOGIN.getName());
    }

    @Bean
    public DirectExchange logUserLoginExchange(){
        return new DirectExchange(ExchangeEnum.USER_LOGIN.getValue());
    }

    @Bean
    public Binding logUserLoginBinding(){
        return BindingBuilder.bind(logUserLoginQueue()).to(logUserLoginExchange()).with(QueueEnum.USER_LOGIN.getRoutingKey());
    }
}
