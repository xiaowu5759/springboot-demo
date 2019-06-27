package com.xiaowu.aysnlog.dao;

import com.xiaowu.aysnlog.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectByUserNamePassword(@Param("username") String username, @Param("password") String password);
}
