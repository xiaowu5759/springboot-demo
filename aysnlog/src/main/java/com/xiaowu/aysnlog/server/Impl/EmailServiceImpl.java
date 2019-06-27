package com.xiaowu.aysnlog.server.Impl;

import com.xiaowu.aysnlog.common.rabbitmq.ExchangeEnum;
import com.xiaowu.aysnlog.common.rabbitmq.QueueEnum;
import com.xiaowu.aysnlog.server.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendEmail(String message) throws Exception {
        try {
            rabbitTemplate.convertAndSend(ExchangeEnum.AYSN_MAIL.getValue(), QueueEnum.AYSN_MAIL.getRoutingKey(), message);
            log.info("我生产了一条消息{}",message);
        }catch (Exception e){
            log.error("EmailServiceImpl.sendEmail", ExceptionUtils.getMessage(e));
        }
    }
}
