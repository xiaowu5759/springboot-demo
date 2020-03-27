package com.xiaowu.rabbitmq02;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

// 两个消息接受者,分别指定不同的 queue
@Component

public class TopicReceiver1 {

    @RabbitListener(queues = "topic.message")
    @RabbitHandler
    public void process(String message){
        System.out.println("Receiver topic.message:"+message);
    }
}
