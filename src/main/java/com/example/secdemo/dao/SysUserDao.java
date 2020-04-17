package com.example.secdemo.dao;

import com.example.secdemo.model.SysUser;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.dao.SysUserDao
 * @Description
 * @createTime 2020/1/3
 */
public interface SysUserDao {
    /**
     * 通过用户名来查找对应的用户
     * @param name
     * @return
     */
    SysUser findUserByName(String name);

    /**
     * 通过用户id来查询用户
     * @param userId
     * @return
     */
    SysUser selectUserById(Long userId);

    /**
     *  通过电话号码查询用户
     * @param phonenumber
     * @return
     */
    SysUser selectUserByPhoneNumber(String phonenumber);

    /**
     *  新增用户
     * @param sysUser
     * @return
     */
    int  insertUser(SysUser sysUser);

    /**
     * 通过用户的信息来更新用户
     * @param sysUser
     * @return
     */
    int updateUser(SysUser sysUser);

    List<SysUser> selectUserListUser(Integer pageNum, Integer pageSize, String orderByColumn, String isAsc, SysUser sysUser);
}
