package com.xiaowu.aysnlog.common.rabbitmq;

import lombok.Getter;

@Getter
public enum QueueEnum {

    USER_LOGIN("log.user.login.queue","log.user.login"),
    AYSN_MAIL("user.mail.queue","user.mail")
    ;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 队列路由键
     */
    private String routingKey;

    QueueEnum(String name, String routingKey) {
        this.name = name;
        this.routingKey = routingKey;
    }
}
