package com.example.secdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.secdemo.dao"})
public class SecdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecdemoApplication.class, args);
    }

}
