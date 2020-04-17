package com.example.secdemo.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.config.security.UnAuthenticationEntryPoint
 * @Description
 * @createTime 2020/1/3
 */
public class UnAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if(isAjaxRequest(request)){
            System.out.println("ajax request");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,e.getMessage());
        }else{
            System.out.println("not ajax request");
            response.sendRedirect("/login");
        }
    }

    public  boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        System.out.println(ajaxFlag);
        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
    }
}
