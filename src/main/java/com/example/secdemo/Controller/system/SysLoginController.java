package com.example.secdemo.Controller.system;

import com.example.secdemo.model.domain.AjaxResult;
import com.example.secdemo.utils.StringUtils;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.Controller.system.SysLoginController
 * @Description
 * @createTime 2020/1/3
 */
@Controller
public class SysLoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
