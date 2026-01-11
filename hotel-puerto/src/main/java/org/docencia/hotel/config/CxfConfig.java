package org.docencia.hotel.config;

import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.docencia.hotel.web.soap.GuestSoapServiceImpl;

/**
 * Configuracion de Apache CXF para servicios SOAP.
 */
@Configuration
public class CxfConfig {

    /**
     * Define el endpoint para el servicio SOAP de huespedes.
     *
     * @param bus  Bus de CXF.
     * @param impl Implementacion del servicio SOAP.
     * @return Endpoint configurado.
     */
    @Bean
    public Endpoint guestEndpoint(Bus bus, GuestSoapServiceImpl impl) {
        EndpointImpl endpoint = new EndpointImpl(bus, impl);
        endpoint.publish("/guest");
        return endpoint;
    }
}
