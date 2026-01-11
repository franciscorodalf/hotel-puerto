package org.docencia.hotel.domain.api;

import org.docencia.hotel.domain.model.Guest;
import java.util.List;

/**
 * Interfaz de dominio para la gestion de huespedes.
 */
public interface GuestDomain {
    /**
     * Crea un nuevo huesped.
     * @param guest Huesped a crear.
     * @return Huesped creado.
     */
    Guest createGuest(Guest guest);

    /**
     * Obtiene un huesped por su ID.
     * @param id ID del huesped.
     * @return Huesped encontrado.
     */
    Guest getGuestById(Long id);

    /**
     * Obtiene todos los huespedes.
     * @return Lista de huespedes.
     */
    List<Guest> getAllGuests();

    /**
     * Actualiza un huesped existente.
     * @param guest Huesped con datos actualizados.
     * @return Huesped actualizado.
     */
    Guest updateGuest(Guest guest);

    /**
     * Elimina un huesped por su ID.
     * @param id ID del huesped a eliminar.
     */
    void deleteGuest(Long id);
}
