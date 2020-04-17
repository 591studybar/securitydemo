package com.example.secdemo.dao;

import com.example.secdemo.model.SysMenu;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.dao.SysMenuDao
 * @Description
 * @createTime 2020/1/6
 */
public interface SysMenuDao {

    List<SysMenu> findAllSysMenuByUserName(String userName);

    List<String> findAllPermsByUserName(String userName);

    List<SysMenu> findAllSysMenuByUserId(Long userId);

    /**
     * 查询系统正常显示菜单（不含按钮）
     *
     * @return 菜单列表
     */
     List<SysMenu> selectMenuNormalAll();

    /**
     * 查询所有菜单
     * @return
     */
     List<SysMenu>  selectMenuAll();

    /**
     * 通过url来查找对应的权限
     * @param url
     * @return
     */
     List<SysMenu> selectMenuByUrl(String url);
}
