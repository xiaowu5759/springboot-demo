package com.xiaowu.springbootmybatis.controller;

import com.xiaowu.springbootmybatis.dao.Course;
import com.xiaowu.springbootmybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/{name}")
    public String queryByName(@PathVariable("name") String name) {
        List result = studentService.queryByName(name);
        return null;
    }
}
