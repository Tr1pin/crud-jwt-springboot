package com.dwes.ProyectoConSeguridad.controller;

import com.dwes.ProyectoConSeguridad.dto.ProductoDTO;
import com.dwes.ProyectoConSeguridad.model.Producto;
import com.dwes.ProyectoConSeguridad.model.User;
import com.dwes.ProyectoConSeguridad.service.ProductoService;
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
@RequestMapping("/productos")
@RestController
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping()
    public List<ProductoDTO> listarProductos(){
        return productoService.listarProductos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("register")
    public ResponseEntity<?> registrarProducto(@Valid @RequestBody Producto producto, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.crearProducto(producto));
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/findProducto")
    public ProductoDTO findByID(@RequestParam Long id){
        return productoService.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id){
        return productoService.deleteProducto(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update")
    public Producto update(@RequestBody Producto producto,@RequestParam Long id){
        return productoService.updateLibro(producto,id);
    }



}
