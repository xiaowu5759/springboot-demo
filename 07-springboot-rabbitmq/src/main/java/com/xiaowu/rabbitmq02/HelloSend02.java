package com.xiaowu.rabbitmq02;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSend02 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send2(int i){
        String context = i + "";
        System.out.println(context+"send2...");
        rabbitTemplate.convertAndSend("hello2",context);
    }

}
