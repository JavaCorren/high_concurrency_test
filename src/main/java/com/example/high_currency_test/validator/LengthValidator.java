package com.example.high_currency_test.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import org.springframework.util.StringUtils;

/**
 * @Author ZhangGR
 * @Created on 2018/8/10
 * @Description
 */
public class LengthValidator extends ValidatorHandler<String> implements Validator<String> {

    private static final int MIN = 0;
    private static final int MAX = 50;

    @Override
    public boolean validate(ValidatorContext context, String s) {

        if (StringUtils.isEmpty(s) || s.length() <= MIN || s.length() > MAX) {
            context.addErrorMsg("字符长度超过允许长度");
            return false;
        }

        return true;
    }
}
