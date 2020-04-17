package com.example.secdemo.Controller;

import com.example.secdemo.model.dto.LoginUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.Controller.IndexController
 * @Description
 * @createTime 2019/12/20
 */
@Controller
@RequestMapping("/test")
public class IndexController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    //@Secured("ROLE_USER")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
    //@PostAuthorize("hasAuthority('ROLE_USER1')")
    public String test(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "/test/test";
    }

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ROLE_USER1')")

    public String test1(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        LoginUser sys = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(sys.getSysUser());
        System.out.println(sys);
        return "/test/test1";
    }


}
