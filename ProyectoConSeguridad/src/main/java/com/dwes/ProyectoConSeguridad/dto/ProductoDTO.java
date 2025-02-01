package com.dwes.ProyectoConSeguridad.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductoDTO {
    private String nombre;
    private double precio;

}
