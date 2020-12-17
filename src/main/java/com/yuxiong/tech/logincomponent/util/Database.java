package com.yuxiong.tech.logincomponent.util;

import com.yuxiong.tech.logincomponent.dao.UserMapper;
import com.yuxiong.tech.logincomponent.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Database {
    SqlSession session;
    boolean keepAlive = false;

    // 初始 session;
    public Database() {
        // 1、读取配置文件
        try {
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

            // 2、创建 SqlSessionFactory 工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);       // 接口无法创建实例，需要工厂构建器

            // 3、使用工厂产生 SqlSession 对象
            this.session = factory.openSession();
        } catch (IOException ioe) {
            System.out.println("Failed to read SqlMapConfig.xml");
        }
    }

    public Database(boolean keepAlive) {
        this();
        this.keepAlive = true;
    }

    public List<User> findAllUsers() {
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            return userMapper.findAll();
        } finally {
            if (!keepAlive)     session.close();
        }
    }

    public User findUserById(Long id) {
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            return userMapper.findById(id);
        } finally {
            if (!keepAlive)     session.close();
        }
    }

    public User findUserByUsername(String username) {
        return null;
    }

    public void insertUser() {

    }

    public void updateUserById(Long id) {

    }

}
