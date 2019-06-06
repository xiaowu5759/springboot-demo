package com.xiaowu.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试项目类
 */
@Controller
public class HelloController {
    /**
     * 测试项目
     * @return
     */
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot";
    }
}
