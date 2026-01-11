package org.docencia.hotel.mapper.nosql;

import org.mapstruct.Mapper;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;

/**
 * Mapper para convertir entre GuestPreferences (Dominio) y GuestPreferencesDocument (MongoDB).
 */
@Mapper(componentModel = "spring")
public interface GuestPreferencesMapper {
    
    /**
     * Convierte un objeto de dominio a un documento MongoDB.
     * @param domain Objeto de dominio.
     * @return Documento MongoDB.
     */
    GuestPreferencesDocument toDocument(GuestPreferences domain);

    /**
     * Convierte un documento MongoDB a un objeto de dominio.
     * @param doc Documento MongoDB.
     * @return Objeto de dominio.
     */
    GuestPreferences toDomain(GuestPreferencesDocument doc);
}
