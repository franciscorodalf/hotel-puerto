package org.docencia.hotel.domain.model;

import java.math.BigDecimal;

/**
 * Modelo de dominio que representa una habitacion.
 */
public class Room {
    /** Identificador unico de la habitacion. */
    private Long id;
    /** Numero de la habitacion. */
    private String number;
    /** Tipo de habitacion (ej. "Simple", "Doble"). */
    private String type;
    /** Precio por noche. */
    private BigDecimal price;
    /** Indica si la habitacion esta disponible. */
    private Boolean available;
    /** Identificador del hotel al que pertenece. */
    private Long hotelId;

    /**
     * Constructor vacio.
     */
    public Room() {}

    /**
     * Constructor con parametros.
     * @param id Identificador.
     * @param number Numero.
     * @param type Tipo.
     * @param price Precio.
     * @param available Disponibilidad.
     * @param hotelId ID del hotel.
     */
    public Room(Long id, String number, String type, BigDecimal price, Boolean available, Long hotelId) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.price = price;
        this.available = available;
        this.hotelId = hotelId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
    public Long getHotelId() { return hotelId; }
    public void setHotelId(Long hotelId) { this.hotelId = hotelId; }
}
