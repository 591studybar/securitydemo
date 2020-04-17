package com.example.secdemo.service.impl;

import com.example.secdemo.model.SysMenu;
import com.example.secdemo.model.SysUser;
import com.example.secdemo.model.dto.LoginUser;
import com.example.secdemo.service.SysUserService;
import com.example.secdemo.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.impl.LoginUserServiceDetails
 * @Description
 * @createTime 2020/1/6
 */
//@Service
public class LoginUserServiceDetails implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysmMenuService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        SysUser sysUser = sysUserService.findUserByName(s);
        if(sysUser==null){
            throw new UsernameNotFoundException("user not found");
        }


        List<SysMenu> sysMenus = new ArrayList<>();


        if(sysUser.isAdmin()){
            sysMenus = sysmMenuService.selectMenuAll();//loginUser.setSysMenus(sysmMenuService.selectMenuAll());
        }else {
            //loginUser.setSysMenus(sysMenus);
            sysMenus = sysmMenuService.findAllSysMenuByUserId(sysUser.getUserId());
        }
        return new LoginUser(sysUser.getLoginName(),sysUser.getPassword(),getAuthorities(sysMenus),sysUser,sysMenus);
    }

    public Collection<GrantedAuthority> getAuthorities(List<SysMenu> sysMenus) {
        List<GrantedAuthority> permission = new ArrayList<>();
        if(!sysMenus.isEmpty()){
            for(SysMenu sysMenu:sysMenus){
                if(sysMenu.getPerms().equals("")||sysMenu.getPerms()==null){
                    continue;
                }
                permission.add(new SimpleGrantedAuthority(sysMenu.getPerms()));
            }
        }
        return permission;
    }
}
