package com.ccb.logback.demo.config;

import com.ccb.logback.demo.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则, 这里假设拦截 /url 后面的全部链接
        InterceptorRegistration ir = registry.addInterceptor(new LogInterceptor());
        ir.addPathPatterns("/**");
        ir.excludePathPatterns("/static/**", "/templates/**");
    }

}
