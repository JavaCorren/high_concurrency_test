package com.example.high_currency_test.conf;

import com.baidu.unbiz.fluentvalidator.interceptor.FluentValidateInterceptor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ZhangGR
 * @Created on 2018/8/10
 * @Description
 */
@Configuration
public class MyValidatorInterceptor {

    MyValidatorCallBack crmValidateCallback = new MyValidatorCallBack();

    @Bean(name="fluentValidateInterceptor")
    public FluentValidateInterceptor fluentValidateInterceptor(){
        FluentValidateInterceptor fluentValidateInterceptor = new FluentValidateInterceptor();
        fluentValidateInterceptor.setCallback(crmValidateCallback);
        fluentValidateInterceptor.setHibernateDefaultErrorCode(10000);
        return fluentValidateInterceptor;
    }

    @Bean
    public BeanNameAutoProxyCreator validateProxyCreator(){
        BeanNameAutoProxyCreator validateProxyCreator = new BeanNameAutoProxyCreator();
        validateProxyCreator.setInterceptorNames("fluentValidateInterceptor");
        validateProxyCreator.setBeanNames("*Impl");
        validateProxyCreator.setProxyTargetClass(true);
        return validateProxyCreator;
    }
}