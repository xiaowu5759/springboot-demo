package com.xiaowu.aysnlog.common.logger;

import com.xiaowu.aysnlog.common.rabbitmq.QueueEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
// 必须手动填上去
@RabbitListener(queues = "log.user.login.queue")
public class UserLoginListener {

//    private String listenerQueue = QueueEnum.USER_LOGIN.getName();

    @RabbitHandler
    public void saveLog(String message){
        log.info("监听到用户登录消息：{}",message);
    }

    // 同时可以把用户的操作 写在数据库中保存，（埋点）
//    @RabbitHandler
//    public void saveSql(String message){
//        System.out.println(message);
//    }



}
