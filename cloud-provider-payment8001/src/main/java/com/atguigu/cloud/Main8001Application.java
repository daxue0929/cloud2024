package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper")
public class Main8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Main8001Application.class, args);
    }
}