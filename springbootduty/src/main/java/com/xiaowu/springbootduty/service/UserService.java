package com.xiaowu.springbootduty.service;

import com.xiaowu.springbootduty.dao.User;

public interface UserService {
    User queryByName(String name);

    User checkLogin(String name, String pwd);
}
