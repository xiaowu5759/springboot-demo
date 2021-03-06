package com.xiaowu.rabbitmq02;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
// 监听 名称为hello的queue
@RabbitListener(queues = "hello")
public class HelloReceiver {
    // 消息处理器
    @RabbitHandler
    public void process(String message){
        System.out.println("Receiver:"+message);
    }
}
