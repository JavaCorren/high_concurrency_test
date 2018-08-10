package com.example.high_currency_test.mapper;

import com.example.high_currency_test.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息 mapper 接口
 */
@Mapper
public interface UserInfoMapper {

    /**
     * 根据主键删除用户信息
     * @param userID
     * @return
     */
    int deleteByPrimaryKey(Long userID);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userID);

    int updateByPrimaryKeySelective(UserInfo record);

}