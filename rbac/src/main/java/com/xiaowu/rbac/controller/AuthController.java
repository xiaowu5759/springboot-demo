package com.xiaowu.rbac.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(){

    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(){

    }
}
