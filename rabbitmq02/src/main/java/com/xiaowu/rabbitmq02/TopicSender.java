package com.xiaowu.rabbitmq02;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send1(){
        String context = "hello,i am message1";
        System.out.println("Sender:"+context);
        rabbitTemplate.convertAndSend("topicExchange","topic.message",context);
    }

    public void send2(){
        String context = "hello,i am message2";
        System.out.println("Sender:"+context);
        rabbitTemplate.convertAndSend("topicExchange","topic.messages",context);
    }
}
