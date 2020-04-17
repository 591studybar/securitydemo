package com.example.secdemo.Controller.system;

import com.example.secdemo.model.SysMenu;
import com.example.secdemo.model.dto.LoginUser;
import com.example.secdemo.service.SysMenuService;
import com.example.secdemo.service.SysUserService;
import com.example.secdemo.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.Controller.system.SysIndexController
 * @Description
 * @createTime 2020/1/3
 */
@Controller
public class SysIndexController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping({"","/index"})
    public String index (ModelMap mmap){
        //List<SysMenu> menus = new ArrayList<>();
//        SysUser user = new SysUser();
//        user.setLoginName("admin");
//        user.setLoginIp("127.0.0.1");
//        user.setLoginDate(new Date());
//        user.setDelFlag("1");
//        user.setDept(new SysDept());
//        user.setPassword("admin");
//        user.setParentId(0L);
//        user.setDeptId(1L);
//        user.setPhonenumber("1231212121");
//        user.setAvatar("ruoyi.png");
//        user.setEmail("1112@qq.com");
        LoginUser user = UserUtil.getLoginUser();

        // 根据用户id取出菜单
       List<SysMenu> menus = sysMenuService.selectMenusByUser(user.getSysUser());

        mmap.put("menus", menus);
        mmap.put("user",user.getSysUser());
        mmap.put("copyrightYear", "2020");
        mmap.put("demoEnabled", "true");
        return "index";
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin(ModelMap mmap)
    {
        return "skin";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", "v1.0.0");
        return "main";
    }

}
