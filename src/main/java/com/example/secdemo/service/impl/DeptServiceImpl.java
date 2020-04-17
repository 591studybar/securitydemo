package com.example.secdemo.service.impl;

import com.example.secdemo.dao.DeptDao;
import com.example.secdemo.model.SysDept;
import com.example.secdemo.model.domain.Ztree;
import com.example.secdemo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.impl.DeptServiceImpl
 * @Description
 * @createTime 2020/1/14
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;


    @Override
    public List<Ztree> selectDeptTree(SysDept sysDept) {
        List<Ztree> list = new LinkedList<>();
        List<SysDept> sysDeptList = deptDao.getSysDeptList(sysDept);
        for (SysDept s:sysDeptList){
            Ztree ztree = new Ztree();
            ztree.setId(s.getDeptId());
            ztree.setpId(s.getParentId());
            ztree.setName(s.getDeptName());
            ztree.setTitle(s.getDeptName());
            list.add(ztree);
        }
        return list;
    }

    @Override
    public SysDept selectDeptById(Long deptId) {
        return deptDao.selectDeptById(deptId);
    }
}
