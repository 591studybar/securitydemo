package com.example.secdemo.service;

import com.example.secdemo.model.SysUser;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.SysUserService
 * @Description
 * @createTime 2020/1/3
 */
public interface SysUserService {

    SysUser findUserByName(String name);


    /**
     * 根据用户ID查询用户所属角色组
     *
     * @param userId 用户ID
     * @return 结果
     */
     String selectUserRoleGroup(Long userId);

    /**
     * 根据用户ID查询用户所属岗位组
     *
     * @param userId 用户ID
     * @return 结果
     */
     String selectUserPostGroup(Long userId);

    /**
     * 通过用户id来查询用户
     * @param userId
     * @return
     */
     SysUser selectUserById(Long userId);


     List<SysUser> selectUserListUser(Integer pageNum,Integer pageSize,String orderByColumn,String isAsc,SysUser sysUser);
}
