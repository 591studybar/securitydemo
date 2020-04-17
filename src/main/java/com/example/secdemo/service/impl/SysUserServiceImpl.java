package com.example.secdemo.service.impl;

import com.example.secdemo.dao.SysUserDao;
import com.example.secdemo.model.SysUser;
import com.example.secdemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.impl.SysUserServiceImpl
 * @Description
 * @createTime 2020/1/3
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser findUserByName(String name) {
        return sysUserDao.findUserByName(name);
    }

    @Override
    public String selectUserRoleGroup(Long userId) {
        return null;
    }

    @Override
    public String selectUserPostGroup(Long userId) {
        return null;
    }

    @Override
    public SysUser selectUserById(Long userId) {
        return sysUserDao.selectUserById(userId);
    }

    @Override
    public List<SysUser> selectUserListUser(Integer pageNum, Integer pageSize, String orderByColumn, String isAsc, SysUser sysUser) {
        return sysUserDao.selectUserListUser(pageNum,pageSize,orderByColumn,isAsc,sysUser);
    }
}
