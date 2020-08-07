package com.jgm.app.servicioitems.domain.services;

import com.jgm.app.servicioitems.domain.clients.ProductoClienteFeign;
import com.jgm.app.servicioitems.domain.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("itemServiceImplFeign")
public class ItemServiceImplFeign implements ItemServiceI {

    @Autowired
    private ProductoClienteFeign productoClienteFeign;

    @Override
    public List<Item> findAll() {
        return productoClienteFeign.findAll().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(productoClienteFeign.findById(id), cantidad);
    }

}