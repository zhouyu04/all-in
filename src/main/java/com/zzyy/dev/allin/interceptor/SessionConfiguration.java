package com.zzyy.dev.allin.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: zhouyu
 * @Date: 2020/12/30 15:43
 * @Description:
 */
@Configuration
public class SessionConfiguration implements WebMvcConfigurer {


    @Autowired
    PicSessionInterceptor picSessionInterceptor;


    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(picSessionInterceptor).addPathPatterns("/picture");
//        registry.addInterceptor(logHandlerInterceptor).addPathPatterns("/**");
    }
}
