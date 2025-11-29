package com.hqhe.agent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 允许所有域
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 显式允许 OPTIONS
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
