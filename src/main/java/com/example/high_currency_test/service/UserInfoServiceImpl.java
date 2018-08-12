package com.example.high_currency_test.service;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.example.high_currency_test.common.UserInfoCommonService;
import com.example.high_currency_test.domain.UserInfo;
import com.example.high_currency_test.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public void saveUser(UserInfo userInfo) {

        //对用户传进来的密码再次增强，并生成主键
        UserInfo.enhance(userInfo);

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

    @Override
    public List<UserInfo> getUser(String userMobile, String userName) {
        return userInfoCommonService.getUserListByMoBileAndName(userMobile, userName);
    }


}
