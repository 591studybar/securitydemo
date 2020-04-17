package com.example.secdemo.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.handler.AjaxAuthFailHandler
 * @Description
 * @createTime 2020/1/3
 */
public class AjaxAuthFailHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //super.onAuthenticationFailure(request, response, exception);
        System.out.println("AjaxAuthFail");
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("{\"status\":\"error\",\"msg\":\"用户名或密码不对\",\"code\":\"1\"}");
        out.flush();
        out.close();
    }
}
