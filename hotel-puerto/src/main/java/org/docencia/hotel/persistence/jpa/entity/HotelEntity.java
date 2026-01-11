package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidad JPA que representa un hotel.
 * Mapea a la tabla "hotel".
 */
@Entity
@Table(name = "hotel")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
    private Integer stars;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomEntity> rooms;

    /**
     * Constructor vacio requerido por JPA.
     */
    public HotelEntity() {}

    /**
     * Obtiene el ID del hotel.
     * @return ID del hotel.
     */
    public Long getId() { return id; }

    /**
     * Establece el ID del hotel.
     * @param id ID del hotel.
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Obtiene el nombre del hotel.
     * @return Nombre del hotel.
     */
    public String getName() { return name; }

    /**
     * Establece el nombre del hotel.
     * @param name Nombre del hotel.
     */
    public void setName(String name) { this.name = name; }

    /**
     * Obtiene la direccion del hotel.
     * @return Direccion del hotel.
     */
    public String getAddress() { return address; }

    /**
     * Establece la direccion del hotel.
     * @param address Direccion del hotel.
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * Obtiene la ciudad del hotel.
     * @return Ciudad del hotel.
     */
    public String getCity() { return city; }

    /**
     * Establece la ciudad del hotel.
     * @param city Ciudad del hotel.
     */
    public void setCity(String city) { this.city = city; }

    /**
     * Obtiene el numero de estrellas del hotel.
     * @return Numero de estrellas.
     */
    public Integer getStars() { return stars; }

    /**
     * Establece el numero de estrellas del hotel.
     * @param stars Numero de estrellas.
     */
    public void setStars(Integer stars) { this.stars = stars; }

    /**
     * Obtiene la lista de habitaciones del hotel.
     * @return Lista de habitaciones.
     */
    public List<RoomEntity> getRooms() { return rooms; }

    /**
     * Establece la lista de habitaciones del hotel.
     * @param rooms Lista de habitaciones.
     */
    public void setRooms(List<RoomEntity> rooms) { this.rooms = rooms; }
}
