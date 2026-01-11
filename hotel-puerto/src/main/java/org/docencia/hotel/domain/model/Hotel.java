package org.docencia.hotel.domain.model;

public class Hotel {
    private Long id;
    private String name;    
    private String address;
    private String city;
    private Integer stars;

    /**
     * Constructor vacio.
     */
    public Hotel() {
    }

    /**
     * Constructor con parametros.
     * 
     * @param id      Identificador.
     * @param name    Nombre.
     * @param address Direccion.
     * @param city    Ciudad.
     * @param stars   Estrellas.
     */
    public Hotel(Long id, String name, String address, String city, Integer stars) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.stars = stars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
