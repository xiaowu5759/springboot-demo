package com.xiaowu.backspringboot.controller;

import com.xiaowu.backspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController{
    @Autowired
    private StudentService studentService;

    @RequestMapping("/{name}")
    public String queryByName(@PathVariable(value = "name")String studentName){
        System.out.println(studentName);
        List result = studentService.queryByName(studentName);
        for(int i = 0; i<= result.size(); i++){
            System.out.println(result.get(i).toString());
        }
        return "/student";

    }
}
