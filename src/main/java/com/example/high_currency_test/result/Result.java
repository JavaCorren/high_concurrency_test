package com.example.high_currency_test.result;

import com.example.high_currency_test.conf.exception.ResultCode;
import com.example.high_currency_test.conf.exception.ResultCodeProperties;
import lombok.Data;

/**
 * 响应结果数据集封装类
 *
 * @author ZhangGR
 * @created on 2018/8/11
 **/
@Data
public class Result<T> {

    private String code ;
    private String msg ;
    private T data;

    public Result (T data) {
        this.code = ResultCode.SUCCESS;
        this.msg = ResultCodeProperties.getErrorMessage(ResultCode.SUCCESS);
        this.data = data;
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
