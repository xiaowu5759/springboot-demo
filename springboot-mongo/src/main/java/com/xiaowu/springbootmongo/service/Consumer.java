package com.xiaowu.springbootmongo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaowu.springbootmongo.entity.MessageDate;
import com.xiaowu.springbootmongo.entity.TboxMessage;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.Date;

/**
 * 消息消费者
 * @createBy XiaoWu
 * @date 2019/9/9 13:55
 */
@Slf4j
@Component
public class Consumer {

	@Autowired
	private TboxMessageService tboxMessageService;

	@JmsListener(destination = "${mymq}")
	public void receiveQueue(Message message) throws JMSException {
		TextMessage textMessage =(TextMessage)message;
//		System.out.println("Consumer收到的报文为:"+textMessage.getText());

		String[] stringFir = textMessage.getText().split("\\|");
		TboxMessage tboxMessage = new TboxMessage();
		tboxMessage.setVin(stringFir[0]);
//		log.info(stringFir[0]);
		String[] stringSec = stringFir[1].split(",", 10);
		tboxMessage.setMessage(stringSec[9].substring(0,stringSec[9].length()-1));
//		log.info(stringSec[9].substring(0,stringSec[9].length()-1));
		String[] stringThi = stringFir[1].split(":", 2)[1].split("}", 2);
//		log.info(stringThi[0]+"}");
		MessageDate messageDate = JSONObject.parseObject(stringThi[0] + "}", MessageDate.class);
		tboxMessage.setMessageDate(messageDate);
		tboxMessageService.saveTboxMessage(tboxMessage);
//		log.info(saveTboxMessage);
	}
}
