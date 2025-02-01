package com.dwes.ProyectoConSeguridad.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PrecioMayorQueCeroValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrecioMayorQueCero {

    String message() default  "debe ser mayor que cero y no estar vacio";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
