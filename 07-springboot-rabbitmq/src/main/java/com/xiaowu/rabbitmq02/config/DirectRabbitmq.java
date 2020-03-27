package com.xiaowu.rabbitmq02.config;

import com.xiaowu.rabbitmq02.DirectEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitmq {
    private DirectEnum directEnum;
    // 这里我们创建两个队列
    @Bean
    public Queue selectDQueue() {
        return new Queue("directSelect");
    }

    @Bean
    public Queue commonDQueue() {
        return new Queue("directCommon");
    }

    // 创建交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    // 绑定交换机
    @Bean
    public Binding bindSelect(Queue selectDQueue,DirectExchange directExchange){
        return BindingBuilder.bind(selectDQueue).to(directExchange).with("error");
    }

    @Bean
    public Binding bindCommon(Queue commonDQueue,DirectExchange directExchange){
        return BindingBuilder.bind(commonDQueue).to(directExchange).with("info");
    }


}


