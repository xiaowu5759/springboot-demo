package com.xiaowu.aysnlog.controller;

import com.xiaowu.aysnlog.common.rabbitmq.ExchangeEnum;
import com.xiaowu.aysnlog.common.rabbitmq.QueueEnum;
import com.xiaowu.aysnlog.common.result.ResultEntity;
import com.xiaowu.aysnlog.common.result.ResultGenerator;
import com.xiaowu.aysnlog.dao.UserMapper;
import com.xiaowu.aysnlog.entity.User;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
//    private Logger logger= LoggerFactory.getLogger(this.getClass());


//    @Autowired
//    private ObjectMapper objectMapper;
//
    @Autowired
    private UserMapper userMapper;
//
//    @Autowired
//    private UserLogMapper userLogMapper;
//
    @Autowired
    private RabbitTemplate rabbitTemplate;


//
//    @Autowired
//    private Environment env;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultEntity login(@RequestParam String username, @RequestParam String password) {
//        BaseResponse response=new BaseResponse(StatusCode.Success);
        User user = userMapper.selectByUserNamePassword(username, password);
        if (user != null) {
            log.info(user.getUsername()+"登录成功");
            //异步写用户日志
            try {
//                UserLog userLog = new UserLog(userName, "Login", "login", objectMapper.writeValueAsString(user));
//                userLog.setCreateTime(new Date());
//                rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//                rabbitTemplate.setExchange(env.getProperty("log.user.exchange.name"));
//                rabbitTemplate.setRoutingKey(env.getProperty("log.user.routing.key.name"));
//
//                Message message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(userLog)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
//                message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, MessageProperties.CONTENT_TYPE_JSON);
//                rabbitTemplate.convertAndSend(message);

                String message = user.getUsername()+"用户登录";
                rabbitTemplate.convertAndSend(ExchangeEnum.USER_LOGIN.getValue(),QueueEnum.USER_LOGIN.getRoutingKey(),message);
                return ResultGenerator.genSucessResult();

            } catch (Exception e) {
                e.printStackTrace();
                return ResultGenerator.genFailureResult();
            }

            //TODO：塞权限数据-资源数据-视野数据
        } else {
            return ResultGenerator.genFailureResult();
        }
    }
}
