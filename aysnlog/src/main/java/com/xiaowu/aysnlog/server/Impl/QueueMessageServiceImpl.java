package com.xiaowu.aysnlog.server.Impl;

import com.xiaowu.aysnlog.common.rabbitmq.ExchangeEnum;
import com.xiaowu.aysnlog.common.rabbitmq.QueueEnum;
import com.xiaowu.aysnlog.server.QueueMessageService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QueueMessageServiceImpl implements QueueMessageService {

    /**
     * 消息队列模板
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum) throws Exception {
        // 设置回调为当前类对象
        rabbitTemplate.setConfirmCallback(this);
        // 构建回调id为uuid
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        // 发送消息到消息队列
        rabbitTemplate.convertAndSend(exchangeEnum.getValue(),queueEnum.getRoutingKey(),message,correlationData);

    }

    /**
     * 消息回调确认方法，b就是ack回应是否发送成功，s就是cause 失败原因
     * @param correlationData
     * @param b
     * @param s
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("回调id:"+correlationData);
        if (b){
            System.out.println("消息发送成功");
        }else{
            System.out.println("消息发送失败："+ s);
        }
    }
}
