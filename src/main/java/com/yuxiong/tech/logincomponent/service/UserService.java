package com.yuxiong.tech.logincomponent.service;

import com.yuxiong.tech.logincomponent.dao.UserMapper;
import com.yuxiong.tech.logincomponent.entity.User;
import com.yuxiong.tech.logincomponent.util.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> findAll() {
        List<User> users = null;

        Database db = new Database();
        try {
            users = userMapper.findAll();
        } catch (Exception e) {
            System.out.println("Failed to get users");
            System.out.println(e.toString());
        }
        return users;
    }

    public User findById(Long id) {
        User user = null;

        Database db = new Database();
        try {
            user = db.findUserById(id);
        } catch (Exception e) {
            System.out.println("Failed to get user");
            System.out.println(e.toString());
        }
        return user;
    }

    public User findByUsername(String username) {
        User user = null;

        Database db = new Database();
        try {
            user = db.findUserByUsername(username);
        } catch (Exception e) {
            System.out.println("Failed to get user");
            System.out.println(e.toString());
        }
        return user;
    }
}
