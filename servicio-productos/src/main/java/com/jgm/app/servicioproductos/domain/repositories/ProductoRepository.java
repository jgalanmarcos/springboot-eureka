package com.jgm.app.servicioproductos.domain.repositories;

import com.jgm.app.serviciocommons.domain.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {


}