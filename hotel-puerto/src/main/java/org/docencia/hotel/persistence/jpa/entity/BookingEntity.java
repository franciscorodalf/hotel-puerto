package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidad JPA que representa una reserva.
 * Mapea a la tabla "booking".
 */
@Entity
@Table(name = "booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkIn;
    private LocalDate checkOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    private GuestEntity guest;

    /**
     * Constructor vacio requerido por JPA.
     */
    public BookingEntity() {}

    /**
     * Obtiene el ID de la reserva.
     * @return ID de la reserva.
     */
    public Long getId() { return id; }

    /**
     * Establece el ID de la reserva.
     * @param id ID de la reserva.
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Obtiene la fecha de entrada.
     * @return Fecha de entrada.
     */
    public LocalDate getCheckIn() { return checkIn; }

    /**
     * Establece la fecha de entrada.
     * @param checkIn Fecha de entrada.
     */
    public void setCheckIn(LocalDate checkIn) { this.checkIn = checkIn; }

    /**
     * Obtiene la fecha de salida.
     * @return Fecha de salida.
     */
    public LocalDate getCheckOut() { return checkOut; }

    /**
     * Establece la fecha de salida.
     * @param checkOut Fecha de salida.
     */
    public void setCheckOut(LocalDate checkOut) { this.checkOut = checkOut; }

    /**
     * Obtiene la habitacion reservada.
     * @return Entidad de la habitacion.
     */
    public RoomEntity getRoom() { return room; }

    /**
     * Establece la habitacion reservada.
     * @param room Entidad de la habitacion.
     */
    public void setRoom(RoomEntity room) { this.room = room; }

    /**
     * Obtiene el huesped que realiza la reserva.
     * @return Entidad del huesped.
     */
    public GuestEntity getGuest() { return guest; }

    /**
     * Establece el huesped que realiza la reserva.
     * @param guest Entidad del huesped.
     */
    public void setGuest(GuestEntity guest) { this.guest = guest; }
}
