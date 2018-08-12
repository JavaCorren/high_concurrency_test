package com.example.high_currency_test.controller;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.example.high_currency_test.conf.exception.ResultCode;
import com.example.high_currency_test.conf.exception.ServiceException;
import com.example.high_currency_test.domain.UserInfo;
import com.example.high_currency_test.result.Result;
import com.example.high_currency_test.service.UserInfoService;
import com.example.high_currency_test.service.UserInfoServiceImpl;
import com.example.high_currency_test.util.MD5Util;
import com.example.high_currency_test.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

/**
 * @author ZhangGR
 * @created on 2018/8/11
 **/
@Controller
public class LoginController {

        @Autowired
        private UserInfoService userInfoService;

        @RequestMapping("/loginPage")
        public String login() {

            return "login";
        }

    /**
     * 验证
     * @param loginVO
     * @return
     * @should test
     */
    @RequestMapping(value = "/login/do_login", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result doLogin(@FluentValid LoginVO loginVO) {

            //获取vo的手机号
            String userMobile = loginVO.getUserMobile();

            //获取vo的用户名称
            String userName = loginVO.getUserName();

            //获取vo的用户密码
            String userPWD = loginVO.getUserPWD();

            //根据用户手机或者用户名获取用户列表
            final List<UserInfo> users = userInfoService.getUser(userMobile, userName);

            //若为空则说明用户没有注册过
            if (CollectionUtils.isEmpty(users)) {
                    throw ServiceException.getServiceExceptionByCode(ResultCode.SPECIFIED_USER_DOES_NOT_EXIST);
            }

            //若存在用户列表，则对密码信息进行比对校验
            return users.stream()
                    .filter(s -> s.getUserMobile().equals(userMobile) && passValidator.test(userPWD, s))
                    .findAny()
                    .map(UserInfo::eraseSensitiveInfo)
                    .map(s -> new Result(s))
                    .orElseThrow(() -> ServiceException.getServiceExceptionByCode(ResultCode.WRONG_USER_PASSWORD));
    }

        /**
         * 密码比对函数
         */
        private BiPredicate<String, UserInfo> passValidator = (s, u) -> {

                String salt = u.getUserSalt();
                String actual = MD5Util.md5(s+salt);
                String anticipated = u.getUserPWD();

                return actual.equals(anticipated);
        };



}
