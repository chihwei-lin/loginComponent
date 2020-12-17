package com.yuxiong.tech.logincomponent.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        String password = charSequence.toString();
        if (charSequence.equals(s)) {
            return true;
        } else {
            return false;
        }
    }
}
