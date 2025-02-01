package com.dwes.ProyectoConSeguridad.repository;

import com.dwes.ProyectoConSeguridad.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
    List<Producto> findAll();

    Optional<Producto> findById(Long id);
}
