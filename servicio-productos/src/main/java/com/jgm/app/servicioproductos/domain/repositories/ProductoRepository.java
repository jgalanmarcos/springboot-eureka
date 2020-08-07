package com.jgm.app.servicioproductos.domain.repositories;

import com.jgm.app.servicioproductos.domain.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
    

}