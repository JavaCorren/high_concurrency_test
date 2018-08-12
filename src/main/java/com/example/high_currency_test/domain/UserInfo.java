package com.example.high_currency_test.domain;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValidate;

import com.example.high_currency_test.conf.exception.ResultCode;
import com.example.high_currency_test.conf.exception.ServiceException;
import com.example.high_currency_test.util.MD5Util;
import com.example.high_currency_test.util.SnowFlakeWorker;
import com.example.high_currency_test.validator.LengthValidator;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

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
     * 用户密码
     */
    private String userPWD;

    /**
     * 用户密码盐
     */
    private String userSalt;

    /**
     * 记录创建时间 （数据库自己维护）
     */
    private Timestamp createStamp;

    /**
     * 记录更新时间（数据库自己维护）
     */
    private Timestamp actionStamp;

    /**
     * 对用户密码进行md5二次加盐增强
     * @param userInfo
     * @return
     */
    public static UserInfo enhance(UserInfo userInfo) {

        if (null == userInfo) {
            throw ServiceException.getServiceExceptionByCode(ResultCode.USER_INFO_OBJECT_IS_NULL);
        }

        //获取用户传进来的密码再次进行MD5加盐加密
        String userPWD = userInfo.getUserPWD();
        String salt = UUID.randomUUID().toString();
        final String finalUserPWD = MD5Util.md5(userPWD+salt);

        //替换掉前端传过来的密码
        userInfo.setUserPWD(finalUserPWD);
        //生成主键
        userInfo.setUserID(SnowFlakeWorker.nextID());

         return userInfo;
    }

    /**
     * 对关键信息擦除，防止被浏览器查看到
     * @param userInfo
     * @return
     */
    public static UserInfo eraseSensitiveInfo(UserInfo userInfo) {

        if (null == userInfo) {
            throw ServiceException.getServiceExceptionByCode(ResultCode.USER_INFO_OBJECT_IS_NULL);
        }

        userInfo.setUserPWD("");
        userInfo.setUserSalt("");
        return userInfo;
    }

}