package com.jgm.app.servicioproductos.infrastructure.controllers;

import com.jgm.app.servicioproductos.domain.entities.Producto;
import com.jgm.app.servicioproductos.domain.services.ProductoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoServiceI productoServiceI;

    @GetMapping
    public List<Producto> findAll() {
        return productoServiceI.findAll();
    }

    @GetMapping("/producto/{id}")
    public Producto findById(@PathVariable Long id) {
        return productoServiceI.findById(id);
    }

}