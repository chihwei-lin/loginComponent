package com.yuxiong.tech.logincomponent;

import org.apache.logging.log4j.ThreadContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuxiong.tech.logincomponent.dao")
public class LogincomponentApplication {

    public static void main(String[] args) {
        // Get the process id
        long id = ProcessHandle.current().pid();
        ThreadContext.put("pid", Long.toString(id));

        SpringApplication.run(LogincomponentApplication.class, args);
    }
}
