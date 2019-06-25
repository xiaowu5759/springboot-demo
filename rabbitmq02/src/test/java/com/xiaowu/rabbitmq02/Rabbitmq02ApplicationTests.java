package com.xiaowu.rabbitmq02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Rabbitmq02ApplicationTests {

    @Autowired
    HelloSender helloSender;

    @Autowired
    HelloSend02 helloSend02;

    @Test
    public void contextLoads(){
        helloSender.send();
    }

    @Test
    public void manyReceiver(){
        for(int i=0;i<100;i++){
            helloSender.send2(i);
        }
    }

    @Test
    public void many2many(){
        for(int i=0;i<100;i++){
            helloSender.send2(i);
            helloSend02.send2(i);
        }
    }

}
