package com.xiaowu.rabbitmq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;

    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        if(username.equals("admin") || password.equals("admin")){
            // 异步写用户日志
            try{

                    rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
                    rabbitTemplate.setExchange(env.getProperty("log.user.exchange.name"));
                    rabbitTemplate.setRoutingKey(env.getProperty("log.user.routing.key.name"));

                    Message message=MessageBuilder.withBody(objectMapper.writeValueAsBytes(userLog)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
                    message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, MessageProperties.CONTENT_TYPE_JSON);
                    rabbitTemplate.convertAndSend(message);
                }catch (Exception e){
                    e.printStackTrace();
                }
        }
    }

}
