package com.example.secdemo.model.dto;

import com.example.secdemo.model.SysMenu;
import com.example.secdemo.model.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.model.dto.LoginUser
 * @Description
 * @createTime 2020/1/9
 */
public class LoginUser extends User {

    private SysUser sysUser;

    private List<SysMenu> sysMenus = new ArrayList<>();

    public List<SysMenu> getSysMenus() {
        return sysMenus;
    }

    public void setSysMenus(List<SysMenu> sysMenus) {
        this.sysMenus = sysMenus;
    }



    public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities, SysUser user, List<SysMenu> sysMenus) {
        super(username, password, authorities);
        this.sysUser = user;
        this.sysMenus = sysMenus;
    }

    public LoginUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, SysUser user, List<SysMenu> sysMenus) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.sysUser = user;
        this.sysMenus = sysMenus;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

}
