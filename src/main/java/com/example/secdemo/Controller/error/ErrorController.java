package com.example.secdemo.Controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.Controller.error.ErrorController
 * @Description
 * @createTime 2020/1/13
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping(value = "/unauth",method = RequestMethod.GET)
    public String uauth(){
        return "/error/unauth";
    }

    @RequestMapping(value = "/404",method = RequestMethod.GET)
    public String error404(){
        return "/error/404";
    }

    @RequestMapping(value = "/500",method = RequestMethod.GET)
    public String error500(){
        return "/error/500";
    }
}
