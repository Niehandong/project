package com.example.monkeyshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.monkeyshop.controller")
@MapperScan(basePackages = "com.example.monkeyshop.mapper")
public class MonkeyshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonkeyshopApplication.class, args);
    }

}
