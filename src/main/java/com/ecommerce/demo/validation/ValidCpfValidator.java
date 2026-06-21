package com.ecommerce.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCpfValidator implements ConstraintValidator<ValidCpf, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return CpfValidator.isValid(value);
    }
}
