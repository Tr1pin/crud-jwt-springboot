package com.dwes.ProyectoConSeguridad.service;

import com.dwes.ProyectoConSeguridad.dto.UserDTO;
import com.dwes.ProyectoConSeguridad.model.Role;
import com.dwes.ProyectoConSeguridad.model.User;
import com.dwes.ProyectoConSeguridad.repository.RoleRepository;
import com.dwes.ProyectoConSeguridad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> obtenerUsuarios(){
        List<User> usuarios = userRepository.findAll();

        return usuarios.stream()
                .map(this::mapUserToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO mapUserToDTO(User user){
        return UserDTO.builder()
                .nombre(user.getUsername())
                .build();
    }


    @Transactional
    public User guardar(User user){

        Optional<Role> optionalRoleUser =  roleRepository.findByName("ROLE_USER");
        List<Role> roles =  new ArrayList<>();
        if(optionalRoleUser.isPresent()){
            roles.add(optionalRoleUser.get());
        }

        if(user.isAdmin()){
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            if(optionalRoleAdmin.isPresent()){
                roles.add(optionalRoleAdmin.get());
            }
        }

        user.setRoles(roles);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }


}
