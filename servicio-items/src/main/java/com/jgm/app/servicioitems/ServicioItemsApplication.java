package com.jgm.app.servicioitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableEurekaClient
// Una vez incluido EurkeClient no es necesario @RibbonClient porque ya la incluye
//@RibbonClient(name = "servicio-productos")
@EnableFeignClients
@SpringBootApplication
public class ServicioItemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioItemsApplication.class, args);
    }

}