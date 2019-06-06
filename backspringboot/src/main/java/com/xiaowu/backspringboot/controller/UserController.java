package com.xiaowu.backspringboot.controller;

import com.xiaowu.backspringboot.dao.User;
import com.xiaowu.backspringboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "*")
//@RestController
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    LoginService loginService;

//    @PostMapping(value = "/{name}/{pwd}",produces = "application/json;charset=UTF-8")
//    @PostMapping(value = "/{name}/{pwd}")
//    public String userLogin(@PathVariable(value = "name") String name, @PathVariable(value = "pwd") String pwd){
//        System.out.println(name + pwd);
////        String result = name + pwd;
////        System.out.println(result);
//        String result = loginService.checkLogin(name, pwd);
//        return result;
//    }

    @RequestMapping("/{name}/{pwd}")
    public User userLoginCheck(@PathVariable(value = "name") String name, @PathVariable(value = "pwd") String pwd){
        System.out.println(name + pwd);
        User result = loginService.checkLogin(name, pwd);
        if(result == null){
            System.out.println("用户不存在");
        }
        else{
            System.out.println(result.toString());
        }
        return result;
    }

    @RequestMapping("/show/{name}/{pwd}")
    public String userShowInfo(@PathVariable(value = "name") String name, @PathVariable(value = "pwd") String pwd, Model model){
        System.out.println(name + pwd);
        User result = loginService.checkLogin(name, pwd);
        model.addAttribute("name",result.getName());
        model.addAttribute("password",result.getPwd());

//        ModelAndView mv = new ModelAndView("userInfo");
////        model.addAttribute("name",result.getName());
////        model.addAttribute("password",result.getPwd());
////        return model;
//        mv.addObject("name",name);
//        mv.addObject("password",pwd);
//        return mv;

        // 使用@restcontroller，返回的就不是从mvc配置出来的 .html 文件
        return "/userInfo";
    }
}
