package com.example.secdemo.config;

import com.example.secdemo.config.security.CustomSaltPasswordEncoder;
import com.example.secdemo.config.security.UnAuthenticationEntryPoint;
import com.example.secdemo.filter.KaptchaFilter;
import com.example.secdemo.handler.AjaxAuthFailHandler;
import com.example.secdemo.handler.AjaxAuthSuccessHandler;
import com.example.secdemo.handler.MyAccessDeniedHandlerImpl;
import com.example.secdemo.service.impl.LoginUserServiceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.config.WebSecurityConfig
 * @Description
 * @createTime 2020/1/3
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("{noop}admin").roles("USER");
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder custpasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new CustomSaltPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //super.configure(web);
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/img/**");
        web.ignoring().antMatchers("/ajax/libs/**");
        web.ignoring().antMatchers("/fonts/**");
        web.ignoring().antMatchers("/i18n/**");
        web.ignoring().antMatchers("/ruoyi/**");
        web.ignoring().antMatchers("/**/favicon.ico");
        web.ignoring().antMatchers("/**/ruoyi.png");
        web.ignoring().antMatchers("/captcha/captchaImage");
        //web.ignoring().antMatchers("/index");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.csrf().disable();//关闭跨脚本攻击
        http.
             addFilterBefore(new KaptchaFilter("/formlogin"), UsernamePasswordAuthenticationFilter.class).
             exceptionHandling().//accessDeniedHandler(new MyAccessDeniedHandlerImpl()).
             authenticationEntryPoint(new UnAuthenticationEntryPoint()).
             and().
                authorizeRequests().
                //antMatchers("/css/**", "/js/**","/img/**", "/fonts/**", "/ajax/**","/ajax/libs/**","/i18n/**","/ruoyi/**","/favicon.ico","/**/ruoyi.png").permitAll().
                anyRequest().authenticated().
             and().
                formLogin().
                loginProcessingUrl("/formlogin").
                successHandler(new AjaxAuthSuccessHandler()).
                failureHandler(new  AjaxAuthFailHandler()).
                loginPage("/login").permitAll().
             and().
                logout().logoutUrl("/logout").
                deleteCookies("JSESSIONID").
                invalidateHttpSession(true).
                clearAuthentication(true).
             and().
                rememberMe().
//             rememberMeServices(tokenBasedRememberMeServices()).
                //tokenRepository(persistentTokenRepository()).
                rememberMeParameter("remember-me").
               // alwaysRemember(true).
                rememberMeCookieDomain("localhost").
                rememberMeCookieName("rememberme").
                tokenValiditySeconds( 24 * 60 * 60).
                userDetailsService(userDetailsService()).
//             key("INTERNAL_SECRET_KEY");
        and().
                headers().
                addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));

    }


    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new LoginUserServiceDetails();
    }




}
