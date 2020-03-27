package com.xiaowu.springbootdemo.controller;

import com.xiaowu.springbootdemo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class EgController {

    @RequestMapping(value="/paramTo", method = RequestMethod.GET)
    /* 后台用Map方法向前端传递参数
     * 传递的参数为message1: String, message2: String, user: User对象
     */
    public String passParam(Map<String, Object> map){

        map.put("message1", "Hello, Spring Boot!");

        map.put("message2", "Hello, Spring Boot!");

        User user = new User(18, "xiaowu");

        map.put("user", user);

        return "result";

    }
    @RequestMapping("/model")
    public String modelTest(Model model) {
        model.addAttribute("modelmsg", "也可以通过给controller方法设置一个Model形参，将响应内容放在	  	model中，<br />然后返回一个视图这样");
        return "model";
    }

}
