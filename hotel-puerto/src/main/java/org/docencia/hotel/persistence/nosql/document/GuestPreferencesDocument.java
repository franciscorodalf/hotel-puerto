package org.docencia.hotel.persistence.nosql.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Documento MongoDB que representa las preferencias de un huesped.
 * Mapea a la coleccion "guest_preferences".
 */
@Document(collection = "guest_preferences")
public class GuestPreferencesDocument {

    @Id
    private String id;
    
    // We will link this to the JPA Guest ID manually or via service logic
    // But typically we might store the JPA ID here or just use the same ID if possible (but JPA is Long, Mongo is String/ObjectId)
    // Let's assume we store the JPA Guest ID as a reference if needed, or just keep it simple.
    // The requirement says "Guest (polyglot): parte en H2 (JPA) + parte en Mongo (NoSQL)".
    // Usually we link them by ID. Let's add a guestId field to link back to JPA entity.
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
