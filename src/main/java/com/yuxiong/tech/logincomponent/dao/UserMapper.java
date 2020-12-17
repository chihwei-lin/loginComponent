package com.yuxiong.tech.logincomponent.dao;

import com.yuxiong.tech.logincomponent.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Calvin Lin
 *
 * 用户持久层接口
 */

@Mapper
public interface UserMapper {

    List<User> findAll();

    User findById(Long id);

    User findByUsername(@Param("username") String username);
}
