package com.example.secdemo.dao;

import com.example.secdemo.model.SysDept;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.dao.DeptDao
 * @Description
 * @createTime 2020/1/14
 */
public interface DeptDao {

    List<SysDept>  getSysDeptList(SysDept sysDept);

    SysDept selectDeptById(Long deptId);
}
