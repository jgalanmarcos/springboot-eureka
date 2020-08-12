package com.jgm.app.servicioproductos.domain.services;

import com.jgm.app.serviciocommons.domain.entities.Producto;

import java.util.List;

public interface ProductoServiceI {

    List<Producto> findAll();

    Producto findById(Long id);

    Producto save(Producto producto);

    Producto update(Producto producto);

    void deleteById(Long id);

}