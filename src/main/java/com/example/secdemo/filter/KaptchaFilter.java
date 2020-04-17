package com.example.secdemo.filter;

import com.google.code.kaptcha.Constants;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.filter.KaptchaFilter
 * @Description
 * @createTime 2020/1/7
 */
public class KaptchaFilter extends AbstractAuthenticationProcessingFilter {
    private String servletPath;
    public KaptchaFilter(String servletPath) {
        super(servletPath);
        this.servletPath = servletPath;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if ("POST".equalsIgnoreCase(req.getMethod()) && servletPath.equals(req.getServletPath())) {
            String expect = (String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if(req.getParameter("validateCode")==""||req.getParameter("validateCode")==null){
                responseMsg(res,"验证码不能为空");
                return;
            }
            if (expect != null && !expect.equalsIgnoreCase(req.getParameter("validateCode"))) {
                responseMsg(res,"验证码不正确");
                return;
            }
        }
        chain.doFilter(request, response);
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        return null;
    }

    public void responseMsg(HttpServletResponse response,String msg) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("{\"status\":\"error\",\"msg\":\""+msg+"\",\"code\":\"1\"}");
        out.flush();
        out.close();
    }

}
