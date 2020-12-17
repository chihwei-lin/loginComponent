package com.yuxiong.tech.logincomponent.auth.service;

import com.yuxiong.tech.logincomponent.dao.UserMapper;
import com.yuxiong.tech.logincomponent.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    private static Logger log = Logger.getLogger(MyUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);

        log.info(username);
        if(user == null)
            throw new UsernameNotFoundException("User does not exist in database");

        List<GrantedAuthority> auths = new ArrayList<>();
        for(String role : user.getRoles().split(",")) {
            auths.add(new SimpleGrantedAuthority("ROLE_"+role));
        }

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), auths);
    }
}
