package com.example.high_currency_test.controller;

import com.example.high_currency_test.domain.UserInfo;
import com.example.high_currency_test.vo.LoginVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ZhangGR
 * @created on 2018/8/12
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

    @Autowired
    private LoginController loginController;
    /**
     * @verifies test
     * @see LoginController#doLogin(com.example.high_currency_test.vo.LoginVO)
     */
    @Test
    public void doLogin_shouldTest() throws Exception {

        LoginVO loginVO = new LoginVO();
        loginController.doLogin(loginVO);
    }
}
