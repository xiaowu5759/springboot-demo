package com.xiaowu.springbootduty.controller;

import com.xiaowu.springbootduty.service.Impl.CheckServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/param")
public class ParamController {

    @Resource
    CheckServiceImpl checkService;

    @PostMapping("/postString/{file}")
    public String postString(@PathVariable(value = "file") String file) {
//        logger.info("POST 传参，传递基本类型。str：{}",str);
        System.out.println(file);
        String result = checkService.check(file);
//        System.out.println(result);
        return result;
    }
}
