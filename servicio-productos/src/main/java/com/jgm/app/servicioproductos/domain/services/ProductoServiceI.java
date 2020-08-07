package com.jgm.app.servicioproductos.domain.services;

import com.jgm.app.servicioproductos.domain.entities.Producto;

import java.util.List;

public interface ProductoServiceI {

    List<Producto> findAll();

    Producto findById(Long id);

}