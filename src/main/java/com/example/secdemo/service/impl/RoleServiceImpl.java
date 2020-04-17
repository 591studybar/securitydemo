package com.example.secdemo.service.impl;

import com.example.secdemo.dao.RoleDao;
import com.example.secdemo.model.SysRole;
import com.example.secdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.impl.RoleServiceImpl
 * @Description
 * @createTime 2020/1/14
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;




    @Override
    public List<SysRole> selectRoleAll(SysRole role) {
        return roleDao.selectRoleList(role);
    }

}
