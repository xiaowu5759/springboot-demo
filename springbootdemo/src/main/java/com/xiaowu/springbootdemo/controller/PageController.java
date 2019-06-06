package com.xiaowu.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping(value = "/helloSpring", method = RequestMethod.GET)
    public String getAccountByName() {
        return "helloSpring";
    }

    @RequestMapping(value = "/param", method = RequestMethod.GET)
    public String parameterPassing() {
        return "parameterPassing";
    }

    @RequestMapping(value = "/note", method = RequestMethod.GET)
    public String note() {
        return "note";
    }
}
