package org.docencia.hotel.web.soap;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import jakarta.jws.WebService;
import org.springframework.stereotype.Service;


@Service
@WebService(
        endpointInterface = "org.docencia.hotel.web.soap.GuestSoapService",
        targetNamespace = "http://hotel.docencia.org/ws",
        serviceName = "GuestSoapService",
        portName = "GuestSoapPort"
)
public class GuestSoapServiceImpl implements GuestSoapService {

    private final GuestDomain guestDomain;

    /**
     * Constructor con inyeccion de dependencias.
     * @param guestDomain Dominio de huespedes.
     */
    public GuestSoapServiceImpl(GuestDomain guestDomain) {
        this.guestDomain = guestDomain;
    }

    /**
     * Obtiene un huesped por su ID.
     * @param id ID del huesped.
     * @return El huesped encontrado.
     */
    @Override
    public Guest getGuestById(Long id) {
        return guestDomain.getGuestById(id);
    }

    /**
     * Guarda un nuevo huesped.
     * @param guest Objeto de dominio del huesped.
     * @return El huesped guardado.
     */
    @Override
    public Guest saveGuest(Guest guest) {
        return guestDomain.createGuest(guest);
    }
}
