package com.example.high_currency_test.common;

import com.example.high_currency_test.domain.UserInfo;
import com.example.high_currency_test.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZhangGR
 * @Created on 2018/8/10
 * @Description
 */
@Service
public class UserInfoCommonService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 添加用户信息
     * @param userInfo
     */
    public void saveUser(UserInfo userInfo) {

        userInfoMapper.insertSelective(userInfo);
    }

    /**
     * 更新用户信息
     * @param userInfo
     */
    public void updateUser(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    /**
     * 根据主键获取用户信息
     * @param pk
     * @return
     */
    public UserInfo getUserByPK(Long pk) {
        return userInfoMapper.selectByPrimaryKey(pk);
    }

    /**
     * 根据主键删除用户信息
     * @param pk
     */
    public void deleteUser(Long pk) {
        userInfoMapper.deleteByPrimaryKey(pk);
    }

    /**
     * 根据用户名查询用户信息（用户名可能重复、因此用列表返回）
     * @param userName
     * @return
     */
    public List<UserInfo> getUserListByMoBileAndName(String userMobile, String userName) {
        return userInfoMapper.getUserByMobileAndName(userMobile, userName);
    }

}
