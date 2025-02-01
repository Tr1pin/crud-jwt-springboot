package com.dwes.ProyectoConSeguridad.model;

import com.dwes.ProyectoConSeguridad.validation.DescripcionSinCaracteresEspeciales;
import com.dwes.ProyectoConSeguridad.validation.PrecioMayorQueCero;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String nombre;

    @PrecioMayorQueCero
    private int precio;

    @DescripcionSinCaracteresEspeciales
    @Size(min = 0, max = 1000)
    private String descripcion;
}
