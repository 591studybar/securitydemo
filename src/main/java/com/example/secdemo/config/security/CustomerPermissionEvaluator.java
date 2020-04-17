package com.example.secdemo.config.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.config.security.CustomerPermissionEvaluator
 * @Description
 * @createTime 2020/1/7
 */
public class CustomerPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
