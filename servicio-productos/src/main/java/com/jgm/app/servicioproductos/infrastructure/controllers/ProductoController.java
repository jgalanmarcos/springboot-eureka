package com.jgm.app.servicioproductos.infrastructure.controllers;

import com.jgm.app.servicioproductos.domain.entities.Producto;
import com.jgm.app.servicioproductos.domain.services.ProductoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}