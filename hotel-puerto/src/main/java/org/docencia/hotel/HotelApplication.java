package org.docencia.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicacion Spring Boot.
 * Inicia el contexto de Spring y la aplicacion.
 */
@SpringBootApplication
public class HotelApplication {

    /**
     * Metodo principal que inicia la aplicacion.
     *
     * @param args Argumentos de linea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }
}
