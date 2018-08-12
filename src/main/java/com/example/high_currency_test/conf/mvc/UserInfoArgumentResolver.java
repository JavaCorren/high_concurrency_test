package com.example.high_currency_test.conf.mvc;

import com.example.high_currency_test.domain.UserInfo;
import com.example.high_currency_test.service.UserInfoService;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

/**
 * 用户信息参数解析类
 *
 * @author ZhangGR
 * @created on 2018/8/12
 **/
@Service
public class UserInfoArgumentResolver implements HandlerMethodArgumentResolver{

    private static final String COOKIE_TOKEN_NAME = "token";
    /**
     * 判断参数类型是否为UserInfo
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(UserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        HttpServletResponse response = (HttpServletResponse) nativeWebRequest.getNativeResponse();

        final Cookie[] cookies = request.getCookies();
//        Cookie[] cookies = new Cookie[1];
//        cookies[0] = new Cookie(COOKIE_TOKEN_NAME, "CORREN");

        if (null != cookies && cookies.length > 0) {
            final Optional<String> value = Arrays.stream(cookies).filter(s -> COOKIE_TOKEN_NAME.equals(s.getName())).findAny().map(s -> s.getValue());
            if (!StringUtils.isEmpty(value)) {
                 return new UserInfo(){{setUserName("Corren");}};
            }

        }

        return null;
    }
}
