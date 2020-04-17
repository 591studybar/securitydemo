package com.example.secdemo.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.handler.MyAccessDeniedHandlerImpl
 * @Description
 * @createTime 2020/1/13
 */
public class MyAccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException e) throws IOException, ServletException {
        res.setContentType("application/json;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.write("{\"status\":\"ok\",\"msg\":\"没有权限访问该页面\",\"code\":\"1\"}");
        out.flush();
        out.close();
    }
}
