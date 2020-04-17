package com.example.secdemo.Controller.system;

import com.example.secdemo.model.SysRole;
import com.example.secdemo.model.SysUser;
import com.example.secdemo.model.domain.AjaxResult;
import com.example.secdemo.model.page.TableDataInfo;
import com.example.secdemo.service.PostService;
import com.example.secdemo.service.RoleService;
import com.example.secdemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.Controller.system.SysUserController
 * @Description
 * @createTime 2020/1/6
 */
@Controller
@RequestMapping("/system/user")
public class SysUserController {

    private static String  prefix = "/system/user";

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PostService postService;


    //@PreAuthorize("hasAuthority('system:user:view')")
    @PreAuthorize("@pms.hasPermission('system:user:view')")
    @GetMapping()
    public String user(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains("system:user:view"));
        return prefix+"/user";
    }

    //@PreAuthorize("hasAuthority('system:user:add')")
    @PreAuthorize("@pms.hasPermission('system:user:view')")
    @RequestMapping("/add")
    public String addUser(ModelMap mmap){

        mmap.put("roles", roleService.selectRoleAll(new SysRole()));
        mmap.put("posts", postService.selectPostAll());
        return prefix+"/add";
    }


    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public TableDataInfo list(@RequestParam String pageSize, @RequestParam String pageNum, @RequestParam String orderByColumn, @RequestParam String isAsc, SysUser sysUser){

        System.out.println(pageNum);
        System.out.println(pageSize);
        System.out.println(orderByColumn);
        System.out.println(isAsc);
        System.out.println(sysUser.getLoginName());
        System.out.println(sysUser.getDeptId());


        TableDataInfo tableDataInfo  = new TableDataInfo();
        List<SysUser> sysUsers = sysUserService.selectUserListUser(Integer.parseInt(pageNum),Integer.parseInt(pageSize),orderByColumn,isAsc,sysUser);
        tableDataInfo.setCode(0);
        tableDataInfo.setRows(sysUsers);
        tableDataInfo.setTotal(sysUsers.size());
        return tableDataInfo;
    }

    @GetMapping("/index")
    public String index(){
        return prefix+"/index";
    }
}
