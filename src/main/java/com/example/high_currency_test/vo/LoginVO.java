package com.example.high_currency_test.vo;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValidate;
import com.example.high_currency_test.conf.exception.ResultCode;
import com.example.high_currency_test.validator.BlankValidator;
import lombok.Data;

/**
 * 用户登陆时候用户接受参数的页面参数对象
 * @author ZhangGR
 * @created on 2018/8/11
 **/
@Data
public class LoginVO {

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户手机号
     */
    @FluentValidate(value = BlankValidator.class, resultCode = ResultCode.BLANK_USER_MOBILE_NOT_ALLOWED)
    private String userMobile;

    /**
     * 用户密码
     */
    @FluentValidate(value = BlankValidator.class)
    private String userPWD;
}
