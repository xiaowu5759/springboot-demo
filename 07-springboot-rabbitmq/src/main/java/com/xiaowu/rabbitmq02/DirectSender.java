package com.xiaowu.rabbitmq02;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    String[] command = {"info","warn","error"};
    public void commonSend(){
        String context = "directSend:";

        for (String aCommand : command) {
            String message = context+aCommand;
            System.out.println(message);
            rabbitTemplate.convertAndSend("directExchange",aCommand,message);
        }


    }
}
