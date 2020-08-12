package com.jgm.app.servicioproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient // indica que será un cliente para el server de eureka
@SpringBootApplication
@EntityScan({"com.jgm.app.serviciocommons.domain.entities"})
// al establecer un proyecto de commons, es necesario esta anotación para que encuentre los package correctos fuera del suyo por defecto
public class ServicioProductosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioProductosApplication.class, args);
    }

}