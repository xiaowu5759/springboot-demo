package com.xiaowu.springbootdemo.controller;

import com.xiaowu.springbootdemo.domain.AccountInfo;
import com.xiaowu.springbootdemo.service.impl.NoteBookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//这种备注非常重要，好像是可以用restful风格传递
@RestController
@RequestMapping("/parameter")
public class ParameterController {
//    private Logger logger = LoggerFactory.getLogger(ParameterController.class);

    @Resource
    private NoteBookServiceImpl noteBookService;

    @GetMapping("/getString/{str}")
    public String getString(@PathVariable(value = "str") String str){
//        logger.info("GET 传参，传递基本类型。str：{}",str);
        System.out.println(str);
        return "收到参数：" + str;
    }

    @PostMapping("/postString/{str}")
    public String postString(@PathVariable(value = "str") String str){
//        logger.info("POST 传参，传递基本类型。str：{}",str);
        System.out.println(str);
        String result = noteBookService.check(str);
        System.out.println(result);
        return "收到参数：" + str;
    }

    @PostMapping("/postAccount")
    public AccountInfo postAccount(@RequestBody AccountInfo accountInfo) {
//        logger.info("GET 传参，传递基本类型。str：{}", accountInfo);
        System.out.println(accountInfo.toString());
        return accountInfo;
    }
}

