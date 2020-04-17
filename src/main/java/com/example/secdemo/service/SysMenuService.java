package com.example.secdemo.service;

import com.example.secdemo.model.SysMenu;
import com.example.secdemo.model.SysUser;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.SysMenuService
 * @Description
 * @createTime 2020/1/6
 */
public interface SysMenuService {

    List<SysMenu> findAllSysMenuByUserName(String s);

    List<SysMenu> findAllSysMenuByUserId(Long userId);

    List<SysMenu> selectMenusByUser(SysUser user);

    List<SysMenu> selectMenuAll();

    List<SysMenu> selectMenuByurl(String url);
}
