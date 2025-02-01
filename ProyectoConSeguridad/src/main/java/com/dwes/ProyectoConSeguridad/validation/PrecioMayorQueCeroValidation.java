package com.dwes.ProyectoConSeguridad.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class PrecioMayorQueCeroValidation implements ConstraintValidator<PrecioMayorQueCero, Integer> {

    @Override
    public boolean isValid(Integer precio, ConstraintValidatorContext constraintValidatorContext){
        return precio != null && precio>0;
    }
}
