package com.example.high_currency_test.conf;

import com.baidu.unbiz.fluentvalidator.DefaultValidateCallback;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.validator.element.ValidatorElementList;

import java.util.List;

/**
 * @Author ZhangGR
 * @Created on 2018/8/10
 * @Description
 */
public class MyValidatorCallBack extends DefaultValidateCallback {

    /**
     * 验证通过要做的事情
     * @param validatorElementList
     */
    @Override
    public void onSuccess(ValidatorElementList validatorElementList) {
        super.onSuccess(validatorElementList);
    }

    /**
     * 验证未通过要做的事情
     * @param validatorElementList
     * @param errors
     */
    @Override
    public void onFail(ValidatorElementList validatorElementList, List<ValidationError> errors) {
        throw new RuntimeException(errors.get(0).toString());
    }

    /**
     * 验证过程中捕获异常做的事情
     * @param validator
     * @param e
     * @param target
     * @throws Exception
     */
    @Override
    public void onUncaughtException(Validator validator, Exception e, Object target) throws Exception {
        super.onUncaughtException(validator, e, target);
    }
}
