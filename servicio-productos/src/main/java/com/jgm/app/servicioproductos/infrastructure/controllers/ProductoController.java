package com.jgm.app.servicioproductos.infrastructure.controllers;

import com.jgm.app.serviciocommons.domain.entities.Producto;
import com.jgm.app.servicioproductos.domain.services.ProductoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    // 1. Utilizando Environment
//    @Autowired
//    private Environment environment;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private ProductoServiceI productoServiceI;

    @GetMapping
    public List<Producto> findAll() {
        return productoServiceI.findAll().stream().map(p -> {
//            p.setPort(Integer.parseInt(environment.getProperty("local.server.port"))); 1. Utilizando Environment
            p.setPort(port);
            return p;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Producto findById(@PathVariable Long id) {
        Producto producto = productoServiceI.findById(id);
//        producto.setPort(Integer.parseInt(environment.getProperty("local.server.port"))); 1. Utilizando Environment
        producto.setPort(port);

        // simular fallo para Hystrix con Excepcion
//        boolean simulado = false;
//        if (!simulado)
//            throw new Exception("Error simulado para Hystrix");

        // simular fallo para Hystrix y Zuul con Timeout
//        try {
//            Thread.sleep(2000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return producto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto save(@RequestBody Producto producto) {
        return productoServiceI.save(producto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto update(@RequestBody Producto producto) {
        return productoServiceI.update(producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        productoServiceI.deleteById(id);
    }

}