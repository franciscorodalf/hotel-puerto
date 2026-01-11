package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String type;
    private BigDecimal price;
    private Boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    /**
     * Constructor vacio requerido por JPA.
     */
    public RoomEntity() {}

    /**
     * Obtiene el ID de la habitacion.
     * @return ID de la habitacion.
     */
    public Long getId() { return id; }

    /**
     * Establece el ID de la habitacion.
     * @param id ID de la habitacion.
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Obtiene el numero de la habitacion.
     * @return Numero de la habitacion.
     */
    public String getNumber() { return number; }

    /**
     * Establece el numero de la habitacion.
     * @param number Numero de la habitacion.
     */
    public void setNumber(String number) { this.number = number; }

    /**
     * Obtiene el tipo de habitacion.
     * @return Tipo de habitacion.
     */
    public String getType() { return type; }

    /**
     * Establece el tipo de habitacion.
     * @param type Tipo de habitacion.
     */
    public void setType(String type) { this.type = type; }

    /**
     * Obtiene el precio de la habitacion.
     * @return Precio de la habitacion.
     */
    public BigDecimal getPrice() { return price; }

    /**
     * Establece el precio de la habitacion.
     * @param price Precio de la habitacion.
     */
    public void setPrice(BigDecimal price) { this.price = price; }

    /**
     * Indica si la habitacion esta disponible.
     * @return true si esta disponible, false en caso contrario.
     */
    public Boolean getAvailable() { return available; }

    /**
     * Establece la disponibilidad de la habitacion.
     * @param available true si esta disponible, false en caso contrario.
     */
    public void setAvailable(Boolean available) { this.available = available; }

    /**
     * Obtiene el hotel al que pertenece la habitacion.
     * @return Entidad del hotel.
     */
    public HotelEntity getHotel() { return hotel; }

    /**
     * Establece el hotel al que pertenece la habitacion.
     * @param hotel Entidad del hotel.
     */
    public void setHotel(HotelEntity hotel) { this.hotel = hotel; }
}
