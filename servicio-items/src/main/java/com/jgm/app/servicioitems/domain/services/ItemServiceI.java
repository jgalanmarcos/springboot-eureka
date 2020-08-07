package com.jgm.app.servicioitems.domain.services;

import com.jgm.app.servicioitems.domain.entities.Item;

import java.util.List;

public interface ItemServiceI {

    List<Item> findAll();

    Item findById(Long id, Integer cantidad);

}