package com.dwes.ProyectoConSeguridad.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class DescripcionSinCaracteresEspecialesValidation implements ConstraintValidator<DescripcionSinCaracteresEspeciales, String> {

    @Override
    public boolean isValid(String desc, ConstraintValidatorContext constraintValidatorContext){
        return desc != null && desc.matches("[a-zA-Z0-9 ]*");
    }
}
