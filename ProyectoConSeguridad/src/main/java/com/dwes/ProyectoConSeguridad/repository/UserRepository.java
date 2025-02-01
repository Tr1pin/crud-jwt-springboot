package com.dwes.ProyectoConSeguridad.repository;

import com.dwes.ProyectoConSeguridad.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    User save (User user);
    Optional<User> findByUsername(String username);
}
