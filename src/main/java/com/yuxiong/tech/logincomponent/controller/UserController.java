package com.yuxiong.tech.logincomponent.controller;

import com.yuxiong.tech.logincomponent.entity.User;
import com.yuxiong.tech.logincomponent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity findAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public User findById(@PathParam("id") Long id) {
        User user = userService.findById(id);
        return user;
    }

    private boolean authenticateUser() {

        return true;
    }
}
