package com.xiaowu.xwsecurity.core.validate.code;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ValidateCodeController {
    // 需要security的工具类
    private SessionStrategy

    @RequestMapping(value = "/code/image", method = RequestMethod.GET)
    public void createCode(HttpServletRequest request, HttpServletResponse response){
        ImageCode imageCode = createImageCode(request);
    }

}
