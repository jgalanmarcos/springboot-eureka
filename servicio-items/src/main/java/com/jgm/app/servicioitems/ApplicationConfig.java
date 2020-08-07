package com.jgm.app.servicioitems;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    /*
     * Si no se le especifica un nombre, por defecto Spring Boot
     * le asigna al Bean el mismo nombre que el del método.
     * Para inyectar como dependencia basta con marcar un
     * @Autowired RestTemplate
     */
    @Bean("clienteRestTemplate")
    @LoadBalanced // Utiliza Ribbon para balancear carga en el caso de usar RestTemplate
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}