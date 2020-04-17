package com.example.secdemo.config;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.config.MvcConfig
 * @Description
 * @createTime 2020/1/13
 */
@Configuration
public class MvcConfig extends WebMvcAutoConfiguration{
    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new ErrorPageRegistrar() {
            @Override
            public void registerErrorPages(ErrorPageRegistry registry) {
                registry.addErrorPages(
                        new ErrorPage(HttpStatus.FORBIDDEN,"/error/unauth"),
                        new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"),
                        new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500")
                );
            }
        };
    }
}
