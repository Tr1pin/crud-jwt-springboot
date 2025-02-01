package com.dwes.ProyectoConSeguridad.service;

import com.dwes.ProyectoConSeguridad.dto.ProductoDTO;
import com.dwes.ProyectoConSeguridad.model.Producto;
import com.dwes.ProyectoConSeguridad.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    private ProductoDTO mapToDTO(Producto producto){
        return ProductoDTO.builder()
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .build();
    }

    public List<ProductoDTO> listarProductos(){
        List<Producto> productos = productoRepository.findAll();

        return productos.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public ProductoDTO findById(Long id){
        Optional<Producto> producto = productoRepository.findById(id);

        if(!producto.isPresent()) throw new RuntimeException("El producto no existe");

        Producto producto1 = producto.get();
        return ProductoDTO.builder()
                .nombre(producto1.getNombre())
                .precio(producto1.getPrecio())
                .build();
    }

    public String deleteProducto(Long id){
        productoRepository.deleteById(id);
        return "Producto borrado";
    }

    public Producto updateLibro(Producto producto,
                long id) {

        Producto productodb
                = productoRepository.findById(id)
                .get();

        if (Objects.nonNull(producto.getDescripcion())
                && !"".equalsIgnoreCase(
                producto.getDescripcion())) {
            productodb.setDescripcion(
                    producto.getDescripcion());
        }

        if (Objects.nonNull(
                producto.getNombre())
                && !"".equalsIgnoreCase(
                producto.getNombre())) {
            productodb.setNombre(
                    productodb.getNombre());
        }

        if (Objects.nonNull(
                producto.getPrecio())
                && 0 < producto.getPrecio()) {
            productodb.setPrecio(
                    producto.getPrecio());
        }

        return productoRepository.save(productodb);
    }
}
