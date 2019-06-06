package com.xiaowu.springbootdemo.service;

import com.xiaowu.springbootdemo.service.impl.NoteBookServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class NoteBookService implements NoteBookServiceImpl {


    @Override
    public String check(String name) {
        if(name != "xiaowu") {
            return "false";
        }

        return "true";

    }
}
