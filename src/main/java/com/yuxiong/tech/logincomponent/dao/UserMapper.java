package com.yuxiong.tech.logincomponent.dao;

import com.yuxiong.tech.logincomponent.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Calvin Lin
 *
 * 用户持久层接口
 */

@Repository
public interface UserMapper {
    List<User> findAll();
}
