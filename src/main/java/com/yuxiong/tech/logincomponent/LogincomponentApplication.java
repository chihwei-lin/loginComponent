package com.yuxiong.tech.logincomponent;

import org.apache.log4j.BasicConfigurator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuxiong.tech.logincomponent.dao")
public class LogincomponentApplication {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(LogincomponentApplication.class, args);
    }

}
