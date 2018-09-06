package com.geekdroid.demo.core.validate;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Validator implements ConstraintValidator<ParamValidator, String> {
    @Override
    public void initialize(ParamValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !(value == null || StringUtils.isEmpty(value));
    }
}
