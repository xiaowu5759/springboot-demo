package com.xiaowu.aysnlog.entity;

import lombok.Data;

@Data
public class Email {
    private String receiver;
    private String subject;
    private String text;
    private String content;

}
