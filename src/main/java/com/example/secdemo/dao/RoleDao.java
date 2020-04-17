package com.example.secdemo.dao;

import com.example.secdemo.model.SysRole;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.dao.RoleDao
 * @Description
 * @createTime 2020/1/14
 */
public interface RoleDao {
    //List<SysRole> selectRoleAll();

    List<SysRole> selectRoleList(SysRole role);
}
