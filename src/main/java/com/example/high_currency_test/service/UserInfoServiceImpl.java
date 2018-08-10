package com.example.high_currency_test.service;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.example.high_currency_test.common.UserInfoCommonService;
import com.example.high_currency_test.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ZhangGR
 * @Created on 2018/8/10
 * @Description
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoCommonService userInfoCommonService;

    /**
     * 添加用户的实现方法
     * @param userInfo
     * @should test
     */
    @Override
    public void saveUser(@FluentValid UserInfo userInfo) {
        userInfoCommonService.saveUser(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {

    }

    @Override
    public void deleteUser(UserInfo userInfo) {

    }

    @Override
    public UserInfo getUser(Long userID) {
        return null;
    }


}
