package org.docencia.hotel.domain.model;

/**
 * Modelo de dominio que representa las preferencias de un huesped.
 */
public class GuestPreferences {
    /** Identificador unico (MongoDB). */
    private String id; 
    /** Requisitos dieteticos. */
    private String dietaryRequirements;
    /** Preferencia de habitacion (ej. "Piso alto", "Silenciosa"). */
    private String roomPreference; 
    /** Peticiones especiales. */
    private String specialRequests;

    /**
     * Constructor vacio.
     */
    public GuestPreferences() {}

    /**
     * Constructor con parametros.
     * @param id Identificador.
     * @param dietaryRequirements Requisitos dieteticos.
     * @param roomPreference Preferencia de habitacion.
     * @param specialRequests Peticiones especiales.
     */
    public GuestPreferences(String id, String dietaryRequirements, String roomPreference, String specialRequests) {
        this.id = id;
        this.dietaryRequirements = dietaryRequirements;
        this.roomPreference = roomPreference;
        this.specialRequests = specialRequests;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getDietaryRequirements() { return dietaryRequirements; }
    public void setDietaryRequirements(String dietaryRequirements) { this.dietaryRequirements = dietaryRequirements; }
    public String getRoomPreference() { return roomPreference; }
    public void setRoomPreference(String roomPreference) { this.roomPreference = roomPreference; }
    public String getSpecialRequests() { return specialRequests; }
    public void setSpecialRequests(String specialRequests) { this.specialRequests = specialRequests; }
}
