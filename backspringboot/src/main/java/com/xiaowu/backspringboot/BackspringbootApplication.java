package com.xiaowu.backspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xiaowu.backspringboot.mapper")
public class BackspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackspringbootApplication.class, args);
    }

}
