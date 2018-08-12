package com.example.high_currency_test.handler;

import com.example.high_currency_test.conf.exception.ServiceException;
import com.example.high_currency_test.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 全局异常处理类
 *
 * @author ZhangGR
 * @created on 2018/8/11
 **/
@EnableWebMvc
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 统一异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {
        ServiceException s = (ServiceException) e;
        return new Result(s.getCode(),e.getMessage());
    }
}
