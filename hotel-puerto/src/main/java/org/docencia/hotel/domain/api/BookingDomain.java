package org.docencia.hotel.domain.api;

import org.docencia.hotel.domain.model.Booking;
import java.util.List;

/**
 * Interfaz de dominio para la gestion de reservas.
 */
public interface BookingDomain {
    /**
     * Crea una nueva reserva.
     * @param booking Reserva a crear.
     * @return Reserva creada.
     */
    Booking createBooking(Booking booking);

    /**
     * Obtiene una reserva por su ID.
     * @param id ID de la reserva.
     * @return Reserva encontrada.
     */
    Booking getBookingById(Long id);

    /**
     * Obtiene todas las reservas.
     * @return Lista de reservas.
     */
    List<Booking> getAllBookings();

    /**
     * Actualiza una reserva existente.
     * @param booking Reserva con datos actualizados.
     * @return Reserva actualizada.
     */
    Booking updateBooking(Booking booking);

    /**
     * Elimina una reserva por su ID.
     * @param id ID de la reserva a eliminar.
     */
    void deleteBooking(Long id);
}
