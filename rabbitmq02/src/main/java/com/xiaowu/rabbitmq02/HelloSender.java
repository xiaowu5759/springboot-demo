package com.xiaowu.rabbitmq02;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class HelloSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        String context = "hello-----"+LocalDateTime.now();
        System.out.println("Send:"+context);
        // 给hello队列发送消息
        rabbitTemplate.convertAndSend("hello",context);
    }

    public void send2(int i){
        String context = i + "";
        System.out.println(context+"send1...");
        rabbitTemplate.convertAndSend("hello2",context);
    }
}
