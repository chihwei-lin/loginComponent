package com.yuxiong.tech.logincomponent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.yuxiong.tech.logincomponent.dao")
public class LogincomponentApplication {

    public static void main(String[] args) {

        SpringApplication.run(LogincomponentApplication.class, args);
    }

}
