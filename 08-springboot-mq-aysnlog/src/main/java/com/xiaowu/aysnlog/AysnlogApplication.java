package com.xiaowu.aysnlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xiaowu.aysnlog.dao")
public class AysnlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AysnlogApplication.class, args);
    }

}
