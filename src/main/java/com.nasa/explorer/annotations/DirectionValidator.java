package com.nasa.explorer.annotations;

import com.nasa.explorer.enuns.Compass;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class DirectionValidator implements ConstraintValidator<DirectionValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.stream(Compass.values()).
                anyMatch(object -> object.getSurname().equals(s.toUpperCase()));
    }
}
