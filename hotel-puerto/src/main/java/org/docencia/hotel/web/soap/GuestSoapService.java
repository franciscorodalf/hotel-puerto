package org.docencia.hotel.web.soap;

import org.docencia.hotel.domain.model.Guest;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;


@WebService(
        name = "GuestSoapService",
        targetNamespace = "http://hotel.docencia.org/ws"
)
public interface GuestSoapService {

    /**
     * Obtiene un huesped por su ID.
     * @param id ID del huesped.
     * @return El huesped encontrado.
     */
    @WebMethod(operationName = "GetGuestById")
    @WebResult(name = "guest")
    Guest getGuestById(@WebParam(name = "id") Long id);

    /**
     * Guarda un nuevo huesped.
     * @param guest Objeto de dominio del huesped.
     * @return El huesped guardado.
     */
    @WebMethod(operationName = "SaveGuest")
    @WebResult(name = "guest")
    Guest saveGuest(@WebParam(name = "guest") Guest guest);
}
