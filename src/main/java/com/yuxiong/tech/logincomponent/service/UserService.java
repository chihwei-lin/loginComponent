package com.yuxiong.tech.logincomponent.service;

import com.yuxiong.tech.logincomponent.dao.UserMapper;
import com.yuxiong.tech.logincomponent.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> findAll() {
        List<User> users = null;

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

        try {
            user = userMapper.findById(id);
        } catch (Exception e) {
            System.out.println("Failed to get user");
            System.out.println(e.toString());
        }
        return user;
    }

    public User findByUsername(String username) {
        User user = null;

        try {
            user = userMapper.findByUsername(username);
        } catch (Exception e) {
            System.out.println("Failed to get user");
            System.out.println(e.toString());
        }
        return user;
    }

    public int login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if(user == null)
            return 201;
        return 200;
    }
}
