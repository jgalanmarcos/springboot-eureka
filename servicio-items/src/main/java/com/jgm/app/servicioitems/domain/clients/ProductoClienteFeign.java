package com.jgm.app.servicioitems.domain.clients;

import com.jgm.app.serviciocommons.domain.entities.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteFeign {

    @GetMapping("/productos")
    List<Producto> findAll();

    @GetMapping("/productos/{id}")
    Producto findById(@PathVariable Long id);

    @PostMapping("/productos")
    Producto save(@RequestBody Producto producto);

    @PutMapping("/productos")
    Producto update(@RequestBody Producto producto);

    @DeleteMapping("/productos/{id}")
    void deleteById(@PathVariable Long id);

}