package com.jgm.app.servicioitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker// indica que será un cliente para el server de eureka
@EnableEurekaClient
//@RibbonClient(name = "servicio-productos") // Una vez incluido EurkeClient no es necesario @RibbonClient porque ya la incluye
@EnableFeignClients
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
// como depende del proyecto common y este no tiene URL de configuración para el DataSource, con esta anotación se omite.
// si se necesita configurar un datasource se quita esta anotación, pero en principio commons no se conectará a base de datos
public class ServicioItemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioItemsApplication.class, args);
    }

}