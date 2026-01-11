package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "guest")
public class GuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    /**
     * Constructor vacio requerido por JPA.
     */
    public GuestEntity() {}

    /**
     * Obtiene el ID del huesped.
     * @return ID del huesped.
     */
    public Long getId() { return id; }

    /**
     * Establece el ID del huesped.
     * @param id ID del huesped.
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Obtiene el nombre del huesped.
     * @return Nombre del huesped.
     */
    public String getFirstName() { return firstName; }

    /**
     * Establece el nombre del huesped.
     * @param firstName Nombre del huesped.
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Obtiene el apellido del huesped.
     * @return Apellido del huesped.
     */
    public String getLastName() { return lastName; }

    /**
     * Establece el apellido del huesped.
     * @param lastName Apellido del huesped.
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Obtiene el email del huesped.
     * @return Email del huesped.
     */
    public String getEmail() { return email; }

    /**
     * Establece el email del huesped.
     * @param email Email del huesped.
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Obtiene el telefono del huesped.
     * @return Telefono del huesped.
     */
    public String getPhone() { return phone; }

    /**
     * Establece el telefono del huesped.
     * @param phone Telefono del huesped.
     */
    public void setPhone(String phone) { this.phone = phone; }
}
