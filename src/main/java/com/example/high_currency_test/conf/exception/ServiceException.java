package com.example.high_currency_test.conf.exception;

import lombok.Data;
import lombok.Getter;

/**
 * 自定义业务异常类
 *
 * @author ZhangGR
 * @created on 2018/8/11
 **/
@Data
public class ServiceException extends RuntimeException {

    @Getter
    public String code;

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    /**
     * 根据错误码构造自定义异常
     * @param code
     * @return
     */
    public static ServiceException getServiceExceptionByCode(String code) {
        String errorMessage = ResultCodeProperties.getErrorMessage(code);
        return new ServiceException(code, errorMessage);
    }
}