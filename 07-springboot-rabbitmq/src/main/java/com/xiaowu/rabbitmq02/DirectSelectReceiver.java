package com.xiaowu.rabbitmq02;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "directSelect")
public class DirectSelectReceiver {

    @RabbitHandler
    public void process(String message){
        System.out.println("Receiver from directSelect:"+message);
    }
}
