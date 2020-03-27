package com.xiaowu.backspringboot.controller;

import com.xiaowu.backspringboot.dao.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/helloUser")
    public User helloUser() {
        User user = new User();
        user.setName("xiaowu");
        user.setPwd("123");
        return user;
    }
}
