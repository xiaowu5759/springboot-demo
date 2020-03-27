package com.xiaowu.rabbitmq02;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void fanoutSend(){
        String context = "hello,fanout msg";
        System.out.println("Sender:"+context);
        // 这里使用了A、B、C三个队列绑定到
        rabbitTemplate.convertAndSend("fanoutExchange","",context);

    }

    public void waitSend(){
        System.out.println("Sender: ...");
    }

}
