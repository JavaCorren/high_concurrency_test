package com.example.high_currency_test.conf.exception;

/**
 * 错误码常量类
 *
 * @author ZhangGR
 * @created on 2018/8/11
 **/
public class ResultCode {

    //系统级错误码
    public static final String SUCCESS = "000"; //系统执行成功
    public static final String SERVER_ERROR = "50001000";//系统内部错误

    //用户登入模块业务异常码
    public static final String SPECIFIED_USER_DOES_NOT_EXIST = "60001001";//指定的用户不存在
    public static final String WRONG_USER_PASSWORD = "60001002";//输入的密码不存在

    //用户管理模块业务异常码
    public static final String BLANK_USER_MOBILE_NOT_ALLOWED = "60002001";//用户手机号不允许为空
    public static final String INVALID_USER_MOBILE_PATTERN = "60002002";//用户手机号格式不正确
    public static final String BLANK_USER_PASSWORD_NOT_ALLOWED = "60002003";//用户密码不允许为空
    public static final String USER_INFO_OBJECT_IS_NULL = "60002004";//用户对象为空

}
