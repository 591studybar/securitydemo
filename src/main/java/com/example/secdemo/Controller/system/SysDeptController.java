package com.example.secdemo.Controller.system;

import com.example.secdemo.model.SysDept;
import com.example.secdemo.model.domain.Ztree;
import com.example.secdemo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.Controller.system.SysDeptController
 * @Description
 * @createTime 2020/1/14
 */
@Controller
@RequestMapping("/system/dept")
public class SysDeptController {

    private String prefix = "system/dept";

    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "/treeData",method = RequestMethod.GET)
    @ResponseBody
    public List<Ztree> treeData(){
        List<Ztree> ztrees = deptService.selectDeptTree(new SysDept());

        return ztrees;
    }

    /**
     * 选择部门树
     */
    @GetMapping("/selectDeptTree/{deptId}")
    public String selectDeptTree(@PathVariable("deptId") Long deptId, ModelMap mmap)
    {
        mmap.put("dept", deptService.selectDeptById(deptId));
        return prefix + "/tree";
    }

}
