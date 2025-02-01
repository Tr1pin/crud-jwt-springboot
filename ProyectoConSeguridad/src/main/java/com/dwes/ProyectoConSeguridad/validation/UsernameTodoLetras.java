package com.dwes.ProyectoConSeguridad.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = UsernameTodoLetrasValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameTodoLetras{

    String message() default  "debe ser todo letras";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

