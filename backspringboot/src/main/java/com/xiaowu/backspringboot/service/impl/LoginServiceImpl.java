package com.xiaowu.backspringboot.service.impl;

import com.xiaowu.backspringboot.dao.User;
import com.xiaowu.backspringboot.dao.UserExample;
import com.xiaowu.backspringboot.mapper.UserMapper;
import com.xiaowu.backspringboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User checkLogin(String name, String pwd) {
//        System.out.println(name + ":"+pwd);
//        UserExample example = new UserExample();
//        example.createCriteria().andNameEqualTo(name);
//        List<User> userList = userMapper.selectByExample(example);
//
//        if (userList != null){
////            System.out.println(userList.get(0).toString());
//            System.out.println("1");
//            return userList.get(0);
//        }
//        else{
//            System.out.println("0");
//            return null;
//        }

//        // 第二次
//        UserExample example = new UserExample();
//        example.createCriteria().andNameEqualTo(name);
//        List<User> userList = userMapper.selectByExample(example);
//        if (userList != null){
//            return userList.get(0);
//        }
//        return null;

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
//    @Override
//    public String checkLogin(String name,String pwd) {
//        String trueName = "xiaowu";
//        String truePwd = "123";
//        String msg;
//        if ( name.equals(trueName) && pwd.equals(truePwd)) {
//            msg = "1";
//            return msg;
//        }
//        msg = "0";
//        return msg;
//    }
}
