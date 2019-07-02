package com.xiaowu.aysnlog.server;

import com.xiaowu.aysnlog.common.rabbitmq.ExchangeEnum;
import com.xiaowu.aysnlog.common.rabbitmq.QueueEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface QueueMessageService extends RabbitTemplate.ConfirmCallback {
    /**
     * 定义发送消息到rabbitmq消息队列
     * @param message
     * @param exchangeEnum
     * @param queueEnum
     * @throws Exception
     */
    public void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum) throws Exception;
}
