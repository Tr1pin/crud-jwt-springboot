package com.dwes.ProyectoConSeguridad.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UsernameTodoLetrasValidation implements ConstraintValidator<UsernameTodoLetras, String> {

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext){
        return username != null && username.matches("[a-zA-Z]+");
    }
}
