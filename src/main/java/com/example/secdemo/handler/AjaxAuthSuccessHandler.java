package com.example.secdemo.handler;

import com.fasterxml.jackson.core.JsonParser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.handler.AjaxAuthSuccessHandler
 * @Description
 * @createTime 2020/1/3
 */
public class AjaxAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //super.onAuthenticationSuccess(request, response, authentication);
        System.out.println("ajaxSuccess");
        //response.setStatus(HttpServletResponse.SC_OK);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("{\"status\":\"ok\",\"msg\":\"登录成功\",\"code\":\"0\"}");
        out.flush();
        out.close();

    }
}
