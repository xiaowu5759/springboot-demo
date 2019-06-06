package com.xiaowu.springbootduty.controller;

import com.xiaowu.springbootduty.dao.User;
import com.xiaowu.springbootduty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/get/{name}/{pwd}",method = RequestMethod.GET)
    public User getUserByName(@PathVariable(value = "name") String name, @PathVariable(value = "pwd") String pwd){
        User user = userService.checkLogin(name, pwd);
        if(user == null){
            System.out.println("用户不存在");
        }
        else{
            System.out.println(user.toString());
        }
        return user;
    }


}
