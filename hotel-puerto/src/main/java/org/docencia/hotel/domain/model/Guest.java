package org.docencia.hotel.domain.model;

/**
 * Modelo de dominio que representa un huesped.
 */
public class Guest {
    /** Identificador unico del huesped. */
    private Long id;
    /** Nombre del huesped. */
    private String firstName;
    /** Apellido del huesped. */
    private String lastName;
    /** Correo electronico del huesped. */
    private String email;
    /** Telefono de contacto. */
    private String phone;
    
    /** Preferencias del huesped (almacenadas en NoSQL). */
    private GuestPreferences preferences;

    /**
     * Constructor vacio.
     */
    public Guest() {}

    /**
     * Constructor con parametros.
     * @param id Identificador.
     * @param firstName Nombre.
     * @param lastName Apellido.
     * @param email Correo electronico.
     * @param phone Telefono.
     * @param preferences Preferencias.
     */
    public Guest(Long id, String firstName, String lastName, String email, String phone, GuestPreferences preferences) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.preferences = preferences;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public GuestPreferences getPreferences() { return preferences; }
    public void setPreferences(GuestPreferences preferences) { this.preferences = preferences; }
}
