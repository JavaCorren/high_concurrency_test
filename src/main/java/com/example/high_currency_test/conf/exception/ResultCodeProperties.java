package com.example.high_currency_test.conf.exception;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * 错误码规范类
 *
 * @author ZhangGR
 * @created on 2018/8/11
 **/
@Component
public class ResultCodeProperties {

    //错误码定义的properties文件路径
    public static final String ERROR_MESSAGE_PATH = "classpath:errorCodeMessage";

    //将spring消息源持有成对象属性
    private static ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

    /**
     * bean实例化完成后设置相应参数
     */
    @PostConstruct
    private static void setErrorProperties() {
        messageSource.setBasename(ERROR_MESSAGE_PATH);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
    }


    /**
     * 根据错误码获取错误详情信息
     * @param errorCode
     * @return
     */
    public static String getErrorMessage(String errorCode) {

        //将参数初始化
        setErrorProperties();

        String errorMessage = messageSource.getMessage(errorCode, null, null);

        if (!StringUtils.isEmpty(errorMessage)) {
            return errorMessage;
        }

        return "";
    }
}

