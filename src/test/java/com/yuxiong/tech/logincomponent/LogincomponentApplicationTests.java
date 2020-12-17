package com.yuxiong.tech.logincomponent;

import com.yuxiong.tech.logincomponent.entity.User;
import com.yuxiong.tech.logincomponent.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class LogincomponentApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        List<User> users = userService.findAll();
        System.out.println(Arrays.toString(users.toArray()));

        User user = userService.findById(1L);
        System.out.println(user.toString());
    }

}
