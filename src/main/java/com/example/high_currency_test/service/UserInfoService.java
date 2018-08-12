package com.example.high_currency_test.service;

import com.example.high_currency_test.domain.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZhangGR
 * @Created on 2018/8/10
 * @Description 用户业务行为接口规范类
 */
public interface UserInfoService {

    /**
     * 添加用户
     * @param userInfo
     */
    void saveUser(UserInfo userInfo);

    /**
     * 更新用户
     * @param userInfo
     */
    void updateUser(UserInfo userInfo);

    /**
     * 删除用户
     * @param userInfo
     */
    void deleteUser(UserInfo userInfo);

    /**
     * 获取用户
     * @param userID
     * @return
     */
    UserInfo getUser(Long userID);

    /**
     *  根据手机号、姓名获取用户信息列表
     * @param userMobile
     * @param userName
     * @return
     */
    List<UserInfo> getUser(String userMobile, String userName);

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    UserInfo getUserInfoByToken(String token);
}
