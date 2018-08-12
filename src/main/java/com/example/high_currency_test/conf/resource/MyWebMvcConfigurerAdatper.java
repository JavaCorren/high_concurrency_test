package com.example.high_currency_test.conf.resource;

import com.example.high_currency_test.conf.mvc.UserInfoArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Spring Boot web配置类 (静态资源类不进行拦截)
 *
 * @author ZhangGR
 * @created on 2018/8/11
 **/
@Configuration
public class MyWebMvcConfigurerAdatper extends WebMvcConfigurationSupport {

    @Autowired
    private UserInfoArgumentResolver userInfoArgumentResolver;

    /**
     * 将存放样式、页面模板的文件目录放行
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**","/static/**").addResourceLocations("classpath:/templates","classpath:/static/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userInfoArgumentResolver);
    }
}
