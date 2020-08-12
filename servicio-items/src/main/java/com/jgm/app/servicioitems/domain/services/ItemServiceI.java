package com.jgm.app.servicioitems.domain.services;

import com.jgm.app.serviciocommons.domain.entities.Producto;
import com.jgm.app.servicioitems.domain.entities.Item;

import java.util.List;

public interface ItemServiceI {

    List<Item> findAll();

    Item findById(Long id, Integer cantidad);

    Producto save(Producto producto);

    Producto update(Producto producto);

    void deleteById(Long id);

}