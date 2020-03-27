package com.xiaowu.springbootmongo.entity;

import lombok.Data;

/**
 * @createBy XiaoWu
 * @date 2019/9/10 8:55
 */
@Data
public class MessageDate {

	private Long time;

	private Integer minutes;

	private Integer seconds;

	private Integer hours;

	private Integer month;

	private Integer year;

	private Integer timezonOffset;

	private Integer day;

	private Integer date;
}
