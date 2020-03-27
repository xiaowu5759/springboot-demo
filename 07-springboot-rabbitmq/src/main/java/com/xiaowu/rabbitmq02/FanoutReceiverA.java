package com.xiaowu.rabbitmq02;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanoutA")
public class FanoutReceiverA {


    @RabbitHandler
    public void process(String message){

        System.out.println("Receiver form fanout.A: "+message);

    }

}
