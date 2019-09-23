package com.xiaowu.springbootmongo.service.impl;

import com.xiaowu.springbootmongo.dao.mongo.TboxMessageRepository;
import com.xiaowu.springbootmongo.entity.TboxMessage;
import com.xiaowu.springbootmongo.service.TboxMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @createBy XiaoWu
 * @date 2019/9/9 14:08
 */
@Service
public class TboxMessageServiceImpl implements TboxMessageService {

	@Autowired
	private TboxMessageRepository tboxMessageRepository;

	@Override
	public String saveTboxMessage(TboxMessage tboxMessage) {
		TboxMessage insert = tboxMessageRepository.insert(tboxMessage);
		return insert.toString();
	}
}
