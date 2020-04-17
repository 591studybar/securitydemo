package com.example.secdemo.config.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.config.security.PermissionService
 * @Description
 * @createTime 2020/1/13
 */
@Service("pms")
public class PermissionService {

    /**
     * 判断接口是否有permission权限
     * @param permission
     * @return
     */
    public boolean hasPermission(String permission) {
        if(StringUtils.isEmpty(permission)){
            return false;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null){
            return false;
        }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();



        for(GrantedAuthority auth:authorities){
            if(auth.getAuthority().equals(permission)){
                return true;
            }
        }


        return false;


    }
}
