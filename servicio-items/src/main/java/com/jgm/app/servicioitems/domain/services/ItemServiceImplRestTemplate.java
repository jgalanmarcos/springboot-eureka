package com.jgm.app.servicioitems.domain.services;

import com.jgm.app.servicioitems.domain.entities.Item;
import com.jgm.app.servicioitems.domain.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("itemServiceImplRestTemplate")
public class ItemServiceImplRestTemplate implements ItemServiceI {

//    RestTemplate usando ruta hardcodeada
//    private static final String PRODUCTOS = "http://localhost:8001/productos";
//    private static final String PRODUCTOS_ID = PRODUCTOS + "/{id}";

    //    RestTemplate usando ruta por nombre de servicio gracias a Ribbon
    private static final String PRODUCTOS = "http://servicio-productos/productos";
    private static final String PRODUCTOS_ID = PRODUCTOS + "/{id}";

    @Autowired
    private RestTemplate clienteRestTemplate;

    @Override
    public List<Item> findAll() {
        List<Producto> productos =
                Arrays.asList(clienteRestTemplate.getForObject(PRODUCTOS, Producto[].class));

        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Producto producto =
                clienteRestTemplate.getForObject(PRODUCTOS_ID, Producto.class, pathVariables);

        return new Item(producto, cantidad);
    }

}