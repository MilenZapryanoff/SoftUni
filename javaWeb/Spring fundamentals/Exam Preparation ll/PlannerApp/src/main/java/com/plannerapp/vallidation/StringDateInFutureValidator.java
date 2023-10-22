package com.plannerapp.vallidation;

import com.plannerapp.model.annotations.StringDateInFuture;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class StringDateInFutureValidator implements ConstraintValidator<StringDateInFuture, String> {
    @Override
    public void initialize(StringDateInFuture constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && !value.isBlank()) {
            LocalDate localDate = LocalDate.parse(value);
            return localDate.isAfter(LocalDate.now());
        }
        return false;
    }
}
