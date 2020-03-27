package com.xiaowu.springbootdemo.controller;

import com.xiaowu.springbootdemo.service.impl.NoteBookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/note")
public class NoteController {

//    @Resource
//    private NoteBookServiceImpl noteBookService;

    @RequestMapping("/check/{name}")
    public String noteCheck(@PathVariable(value = "name") String name){
        System.out.println(name);
//        String result = noteBookService.check(name);
//        System.out.println(result);
        return name;
    }
}
