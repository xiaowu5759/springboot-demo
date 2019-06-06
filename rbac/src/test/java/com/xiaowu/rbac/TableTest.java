package com.xiaowu.rbac;

import com.xiaowu.rbac.dao.RoleMapper;
import com.xiaowu.rbac.dao.UserMapper;
import com.xiaowu.rbac.dao.UsersRolesMapper;
import com.xiaowu.rbac.entity.*;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
//@MapperScan(basePackages = "com.xiaowu.rbac.dao")
public class TableTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UsersRolesMapper usersRolesMapper;

    @Test
    public void ManyTable(){
        if (userMapper == null) {
            System.out.println("userMapper为空");
        }
        User user = userMapper.findByUsername("xiaowu");
        UsersRolesExample usersRolesExample = new UsersRolesExample();
        UsersRolesExample.Criteria usersRolesExampleCriteria = usersRolesExample.createCriteria();
        usersRolesExampleCriteria.andUserIdEqualTo(user.getId());
        List<UsersRoles> usersRolesList = usersRolesMapper.selectByExample(usersRolesExample);

        List<Integer> roleIds = usersRolesList.stream().map(UsersRoles::getRoleId).distinct().collect(Collectors.toList());

        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria roleExampleCriteria = roleExample.createCriteria();
        roleExampleCriteria.andIdIn(roleIds);
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        System.out.println(roleList.toString());
    }

}
