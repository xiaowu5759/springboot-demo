package com.xiaowu.springbootmybatis.service;

import com.xiaowu.springbootmybatis.dao.Course;

import java.util.List;

public interface StudentService {
    List queryByName(String name);
}
