package com.xiaowu.aysnlog.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiaowu.aysnlog.common.result.ResultEntity;
import com.xiaowu.aysnlog.common.result.ResultGenerator;
import com.xiaowu.aysnlog.server.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/mail",method = RequestMethod.POST)
    public ResultEntity add(@RequestBody JSONObject jsonObject)throws Exception {
        emailService.sendEmail(jsonObject.toJSONString());
        return ResultGenerator.genSucessResult();
    }
}
