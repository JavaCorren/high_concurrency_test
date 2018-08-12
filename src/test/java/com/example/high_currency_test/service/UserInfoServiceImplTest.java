package com.example.high_currency_test.service;

import com.example.high_currency_test.domain.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author ZhangGR
 * @Created on 2018/8/10
 * @Description
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * @verifies test
     * @see UserInfoServiceImpl#saveUser(com.example.high_currency_test.domain.UserInfo)
     */
    @Test
    public void saveUser_shouldTest() throws Exception {

        UserInfo userInfo = null;
        userInfoService.saveUser(userInfo);
    }
}
