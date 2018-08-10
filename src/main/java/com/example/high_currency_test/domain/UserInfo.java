package com.example.high_currency_test.domain;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValidate;
import com.example.high_currency_test.validator.LengthValidator;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class UserInfo implements Serializable {

    /**
     * 用户主键
     */
    private Long userID;

    /**
     * 用户名称
     */
    @FluentValidate(value = LengthValidator.class)
    private String userName;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 用户手机号码
     */
    private String userMobile;

    /**
     * 记录创建时间 （数据库自己维护）
     */
    private Timestamp createStamp;

    /**
     * 记录更新时间（数据库自己维护）
     */
    private Timestamp actionStamp;

}