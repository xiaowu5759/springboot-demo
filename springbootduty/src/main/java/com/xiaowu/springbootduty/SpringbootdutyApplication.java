package com.xiaowu.springbootduty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xiaowu.springbootduty.mapper")
public class SpringbootdutyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdutyApplication.class, args);
    }

}
