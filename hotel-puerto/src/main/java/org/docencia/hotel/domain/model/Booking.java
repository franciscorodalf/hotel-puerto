package org.docencia.hotel.domain.model;

import java.time.LocalDate;

/**
 * Modelo de dominio que representa una reserva.
 */
public class Booking {
    /** Identificador unico de la reserva. */
    private Long id;
    /** Fecha de entrada. */
    private LocalDate checkIn;
    /** Fecha de salida. */
    private LocalDate checkOut;
    /** Identificador de la habitacion reservada. */
    private Long roomId;
    /** Identificador del huesped que realiza la reserva. */
    private Long guestId;

    /**
     * Constructor vacio.
     */
    public Booking() {}

    /**
     * Constructor con parametros.
     * @param id Identificador.
     * @param checkIn Fecha de entrada.
     * @param checkOut Fecha de salida.
     * @param roomId ID de la habitacion.
     * @param guestId ID del huesped.
     */
    public Booking(Long id, LocalDate checkIn, LocalDate checkOut, Long roomId, Long guestId) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomId = roomId;
        this.guestId = guestId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getCheckIn() { return checkIn; }
    public void setCheckIn(LocalDate checkIn) { this.checkIn = checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public void setCheckOut(LocalDate checkOut) { this.checkOut = checkOut; }
    public Long getRoomId() { return roomId; }
    public void setRoomId(Long roomId) { this.roomId = roomId; }
    public Long getGuestId() { return guestId; }
    public void setGuestId(Long guestId) { this.guestId = guestId; }
}
