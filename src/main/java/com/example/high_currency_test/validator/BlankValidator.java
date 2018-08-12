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
public class BlankValidator extends ValidatorHandler<String> implements Validator<String> {


    @Override
    public boolean validate(ValidatorContext context, String s) {

        if (StringUtils.isEmpty(s) ) {
            return false;
        }

        return true;
    }
}
