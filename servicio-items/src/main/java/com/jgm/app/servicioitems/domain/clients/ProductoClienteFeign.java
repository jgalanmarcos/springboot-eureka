package com.jgm.app.servicioitems.domain.clients;

import com.jgm.app.servicioitems.domain.entities.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteFeign {

    @GetMapping("/productos")
    public List<Producto> findAll();

    @GetMapping("/productos/{id}")
    public Producto findById(@PathVariable Long id);

}