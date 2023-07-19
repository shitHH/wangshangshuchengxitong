package com.etc.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zwh
 * @date 2021/11/23
 */
@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/*.action")
                .excludePathPatterns("/","index.action","/tologin.action","/captcaha.action","/toadd.action","/adduser.action","/toahthenticateduser.action","/ahthenticateduser.action","/usereditpass.action","/checktel.action");
    }
}
