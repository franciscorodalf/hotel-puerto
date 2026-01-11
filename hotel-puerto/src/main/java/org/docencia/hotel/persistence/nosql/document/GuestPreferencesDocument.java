package org.docencia.hotel.persistence.nosql.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "guest_preferences")
public class GuestPreferencesDocument {

    @Id
    private String id;

    private Long guestId;

    private String dietaryRequirements;
    private String roomPreference;
    private String specialRequests;

    /**
     * Constructor vacio.
     */
    public GuestPreferencesDocument() {}

    /**
     * Obtiene el ID del documento.
     * @return ID del documento.
     */
    public String getId() { return id; }

    /**
     * Establece el ID del documento.
     * @param id ID del documento.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Obtiene el ID del huesped asociado (JPA).
     * @return ID del huesped.
     */
    public Long getGuestId() { return guestId; }

    /**
     * Establece el ID del huesped asociado (JPA).
     * @param guestId ID del huesped.
     */
    public void setGuestId(Long guestId) { this.guestId = guestId; }

    /**
     * Obtiene los requisitos dieteticos.
     * @return Requisitos dieteticos.
     */
    public String getDietaryRequirements() { return dietaryRequirements; }

    /**
     * Establece los requisitos dieteticos.
     * @param dietaryRequirements Requisitos dieteticos.
     */
    public void setDietaryRequirements(String dietaryRequirements) { this.dietaryRequirements = dietaryRequirements; }

    /**
     * Obtiene las preferencias de habitacion.
     * @return Preferencias de habitacion.
     */
    public String getRoomPreference() { return roomPreference; }

    /**
     * Establece las preferencias de habitacion.
     * @param roomPreference Preferencias de habitacion.
     */
    public void setRoomPreference(String roomPreference) { this.roomPreference = roomPreference; }

    /**
     * Obtiene las peticiones especiales.
     * @return Peticiones especiales.
     */
    public String getSpecialRequests() { return specialRequests; }

    /**
     * Establece las peticiones especiales.
     * @param specialRequests Peticiones especiales.
     */
    public void setSpecialRequests(String specialRequests) { this.specialRequests = specialRequests; }
}
