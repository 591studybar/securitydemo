package com.example.secdemo.Controller.system;

import com.example.secdemo.model.domain.AjaxResult;
import com.example.secdemo.model.dto.LoginUser;
import com.example.secdemo.service.SysUserService;
import com.example.secdemo.utils.Md5Utils;
import com.example.secdemo.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.Controller.system.SysProfileController
 * @Description
 * @createTime 2020/1/7
 */
@Controller
@RequestMapping("/system/user/profile")
public class SysProfileController {

    private static final Logger log = LoggerFactory.getLogger(SysProfileController.class);

    private String prefix = "system/user/profile";

    @Autowired
    private SysUserService userService;


    /**
     * 个人信息
     */
    @GetMapping()
    public String profile(ModelMap mmap){
        LoginUser user = UserUtil.getLoginUser();
        mmap.put("user", user.getSysUser());
        mmap.put("roleGroup","rolegroup" );
        mmap.put("postGroup", "postgroup");

        return prefix + "/profile";

    }

    @GetMapping("/resetPwd")
    public String resetPwd(ModelMap mmap)
    {
        LoginUser user = UserUtil.getLoginUser();
        mmap.put("user", userService.selectUserById(user.getSysUser().getUserId()));
        return prefix + "/resetPwd";
    }

    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwd(String oldPassword, String newPassword)
    {
        LoginUser user = UserUtil.getLoginUser();

        if(user.getPassword().equals(Md5Utils.encode(oldPassword))){


        }
        return AjaxResult.success("修改成功");
    }


}
