package com.example.high_currency_test.conf.resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring Boot web配置类 (静态资源类不进行拦截)
 *
 * @author ZhangGR
 * @created on 2018/8/11
 **/
@Configuration
public class MyWebMvcConfigurerAdatper extends WebMvcConfigurerAdapter {

    /**
     * 将存放样式、页面模板的文件目录放行
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**","/static/**").addResourceLocations("classpath:/templates","classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
