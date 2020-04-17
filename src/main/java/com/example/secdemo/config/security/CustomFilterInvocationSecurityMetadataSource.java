package com.example.secdemo.config.security;

import com.example.secdemo.model.SysMenu;
import com.example.secdemo.service.SysMenuService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.config.security.CustomFilterInvocationSecurityMetadataSource
 * @Description
 * @createTime 2020/1/7
 */
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private SysMenuService menuService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println("requestUrl:"+requestUrl);
        List<SysMenu> permissionList = menuService.selectMenuByurl(requestUrl);

        if(permissionList == null || permissionList.size() == 0){
            //请求路径没有配置权限，表明该请求接口可以任意访问
            return null;
        }
        String[] attributes = new String[permissionList.size()];
        for(int i = 0;i<permissionList.size();i++){
            attributes[i] = permissionList.get(i).getPerms();
        }
        System.out.println(attributes);
        return SecurityConfig.createList(attributes);

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
