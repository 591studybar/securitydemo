package com.example.secdemo.service;

import com.example.secdemo.model.SysDept;
import com.example.secdemo.model.domain.Ztree;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.DeptService
 * @Description
 * @createTime 2020/1/14
 */
public interface DeptService {

    List<Ztree> selectDeptTree(SysDept sysDept);

    SysDept selectDeptById(Long deptId);
}
