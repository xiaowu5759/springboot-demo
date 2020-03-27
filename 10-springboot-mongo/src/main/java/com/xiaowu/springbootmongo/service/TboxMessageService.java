package com.xiaowu.springbootmongo.service;

import com.xiaowu.springbootmongo.entity.TboxMessage;

/**
 * @createBy XiaoWu
 * @date 2019/9/9 14:06
 */
public interface TboxMessageService {
	// 向mongodb 中存 message
	public String saveTboxMessage(TboxMessage tboxMessage);
}
