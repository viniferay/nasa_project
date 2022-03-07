package com.nasa.explorer.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DirectionValidator.class)
public @interface DirectionValidation {
    public String message() default "Direção invalida. As direções varidas são N, S, E e W.";
    public Class<?> [] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
