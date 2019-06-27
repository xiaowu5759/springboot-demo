package com.xiaowu.aysnlog.common.rabbitmq;

import lombok.Getter;

@Getter
public enum ExchangeEnum {

    USER_LOGIN("log.user.login.direct.exchange"),
    AYSN_MAIL("user.mail.topic.exchange")
    ;
    private String value;

    ExchangeEnum(String value) {
        this.value = value;
    }
}
