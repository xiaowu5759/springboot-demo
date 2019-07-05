package com.xiaowu.xwsecurity.browser;

import com.xiaowu.xwsecurity.browser.authentication.XiaowuAuthenticationFailureHandler;
import com.xiaowu.xwsecurity.browser.authentication.XiaowuAuthenticationSuccessHandler;
import com.xiaowu.xwsecurity.core.properties.SecurityProperties;
import com.xiaowu.xwsecurity.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private XiaowuAuthenticationFailureHandler xiaowuAuthenticationFailureHandler;

    @Autowired
    private XiaowuAuthenticationSuccessHandler xiaowuAuthenticationSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 随机生成的盐，混在里面
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(xiaowuAuthenticationFailureHandler);

        // 至少是表单登录
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
        // basic登录
//        http.httpBasic()
                // /authentication/require
                .loginPage("/authentication/require")
                // 处理登录的url是什么
                .loginProcessingUrl("/authentication/form")
                .failureHandler(xiaowuAuthenticationFailureHandler)
                .successHandler(xiaowuAuthenticationSuccessHandler)
                .and()
                // 下面这些 都是授权的配置
                .authorizeRequests()
                .antMatchers("/authentication/require", securityProperties.getBrowser().getLoginPage(),"/code/image").permitAll()
                .antMatchers("/authentication/form").permitAll()
                .anyRequest()
                .authenticated();
    }
}
