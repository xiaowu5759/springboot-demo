package com.xiaowu.springbootduty.service;

import com.xiaowu.springbootduty.service.Impl.CheckServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CheckService implements CheckServiceImpl {
    @Override
    public String check(String file) {
        switch (file){
            case ".mp3":
                System.out.println("这是一个音乐文件");
                return "音乐";
            case ".txt":
                System.out.println("这是一个文本文件");
                return "文本";
            default:
                System.out.println("这不是一个文件");
                return "未知";
        }
    }
}
