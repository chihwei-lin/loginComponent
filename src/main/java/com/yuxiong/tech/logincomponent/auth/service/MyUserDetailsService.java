package com.yuxiong.tech.logincomponent.auth.service;

import com.yuxiong.tech.logincomponent.dao.UserMapper;
import com.yuxiong.tech.logincomponent.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.Logger;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    private static Logger log = LogManager.getLogger(MyUserDetailsService.class);

    static {
        // Get the process id
        String pid = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(pid);
        long id = ProcessHandle.current().pid();
        System.out.println(id);
        ThreadContext.put("pid", Long.toString(id));
        System.out.println(ThreadContext.get("pid"));
    }

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

        log.info(user.getPassword());
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), auths);
    }
}
