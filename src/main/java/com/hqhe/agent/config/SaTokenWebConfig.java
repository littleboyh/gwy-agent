package com.hqhe.agent.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;

// @Configuration
public class SaTokenWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handler -> {
                    /*HttpServletRequest request = handler.getRequest();
                    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
                        return;
                    }*/
                    StpUtil.checkLogin();
                }))
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/api/v1/auth/**",
                        "/error",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v3/**",
                        "/swagger-ui/**",
                        "/doc.html",
                        "/favicon.ico"
                );
    }
}
