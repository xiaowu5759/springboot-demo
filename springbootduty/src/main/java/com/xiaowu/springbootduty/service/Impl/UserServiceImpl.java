package com.xiaowu.springbootduty.service.Impl;

import com.xiaowu.springbootduty.dao.User;
import com.xiaowu.springbootduty.dao.UserExample;
import com.xiaowu.springbootduty.mapper.UserMapper;
import com.xiaowu.springbootduty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryByName(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> userList = userMapper.selectByExample(example);
        System.out.println(userList.size());
        if (userList.size() != 0){
            return userList.get(0);
        }
        return null;

    }

    @Override
    public User checkLogin(String name, String pwd) {
        UserExample userExample = new UserExample();
        UserExample.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andNameEqualTo(name).andPwdEqualTo(pwd);
        List<User> userList = userMapper.selectByExample(userExample);
        System.out.println(userList.size());
        if (userList.size() != 0){
            return userList.get(0);
        }
        return null;
    }
}
