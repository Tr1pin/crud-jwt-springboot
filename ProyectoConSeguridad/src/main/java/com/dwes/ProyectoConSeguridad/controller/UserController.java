package com.dwes.ProyectoConSeguridad.controller;

import com.dwes.ProyectoConSeguridad.dto.UserDTO;
import com.dwes.ProyectoConSeguridad.model.User;
import com.dwes.ProyectoConSeguridad.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", originPatterns = "*")
@EnableWebSecurity
@EnableMethodSecurity
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> obtenerUsuarios(){
        return userService.obtenerUsuarios();
    }

    @PostMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.guardar(user));
    }


    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @PreAuthorize("hasrole('ADMIN')")
    @PostMapping("register")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody User user, BindingResult result){
        user.setAdmin(false);
        user.setEnabled(true);
        return crearUsuario(user,result);

    }



}
