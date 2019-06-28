package com.xiaowu.rbac.security;

import com.xiaowu.rbac.entity.User;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 重写springsecurity 核心接口
 */
public class MyUserDetails extends User implements UserDetails {

//    private Integer id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    MyUserDetails() {
    }

    MyUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 用户是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否冻结
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 密码是否过期，三十天变换密码
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 账户是否不可用，假删除，不能恢复，校验逻辑 Service
    @Override
    public boolean isEnabled() {
        return true;
    }
}
