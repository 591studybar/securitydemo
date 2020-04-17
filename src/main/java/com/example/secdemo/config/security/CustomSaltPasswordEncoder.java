package com.example.secdemo.config.security;

import com.example.secdemo.utils.Md5Utils;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.config.security.CustomSaltPasswordEncoder
 * @Description
 * @createTime 2020/1/6
 */
public class CustomSaltPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return Md5Utils.encode((String)charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword) {
        return encodedPassword.equals(Md5Utils.encode((String)charSequence));
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return true;
    }
}
