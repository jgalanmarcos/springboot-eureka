package com.jgm.app.serviciocommons;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
// Sobreescribe a la anotación contenida en @SpringBootApplication para deshabilitar la conexión a base de datos,
// ya que no es necesaria en este proyecto
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ServicioCommonsApplication {


}