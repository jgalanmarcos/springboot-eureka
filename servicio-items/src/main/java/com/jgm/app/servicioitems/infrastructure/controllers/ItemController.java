package com.jgm.app.servicioitems.infrastructure.controllers;

import com.jgm.app.servicioitems.domain.entities.Item;
import com.jgm.app.servicioitems.domain.entities.Producto;
import com.jgm.app.servicioitems.domain.services.ItemServiceI;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    @Qualifier("itemServiceImplFeign")
    private ItemServiceI itemServiceI;

    @GetMapping
    public List<Item> findAll() {
        return itemServiceI.findAll();
    }

    // Saltar al método callBackError() si se produce un error
    @HystrixCommand(fallbackMethod = "callBackError")
    @GetMapping("/{id}/cantidad/{cantidad}")
    public Item findById(@PathVariable Long id, @PathVariable Integer cantidad) {
        return itemServiceI.findById(id, cantidad);
    }

    public Item callBackError(Long id, Integer cantidad) {
        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre("Por defecto");
        producto.setPrecio(0.0);

        Item item = new Item();
        item.setProducto(producto);
        item.setCantidad(cantidad);
        
        return item;
    }

}