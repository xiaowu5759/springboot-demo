package com.xiaowu.rabbitmq02;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanoutB")
public class FanoutReceiverB {


    @RabbitHandler
    public void process(String message){

        System.out.println("Receiver form fanout.B: "+message);

    }

}
