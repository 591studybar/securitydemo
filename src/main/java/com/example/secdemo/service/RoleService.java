package com.example.secdemo.service;

import com.example.secdemo.model.SysRole;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.RoleService
 * @Description
 * @createTime 2020/1/14
 */
public interface RoleService {

    List<SysRole> selectRoleAll(SysRole role);
}
