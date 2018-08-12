package com.example.high_currency_test.conf.handler;

import com.example.high_currency_test.conf.exception.ServiceException;
import com.example.high_currency_test.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 *
 * @author ZhangGR
 * @created on 2018/8/11
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 统一异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {

        //若为业务异常封装成响应格式给前端处理
        if (e instanceof ServiceException) {
            ServiceException s = (ServiceException)e;
            return new Result(s.getCode(), s.getMessage());
        }

        e.printStackTrace();
        //非业务异常视作系统异常
        return new Result("500", e.getMessage());
    }
}
