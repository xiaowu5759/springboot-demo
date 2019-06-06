package com.xiaowu.backspringboot.service;

import com.xiaowu.backspringboot.dao.User;
import org.springframework.stereotype.Service;


public interface LoginService {
    User checkLogin(String name, String pwd);
}
