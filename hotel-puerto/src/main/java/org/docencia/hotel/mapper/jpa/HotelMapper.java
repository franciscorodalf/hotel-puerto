package org.docencia.hotel.mapper.jpa;

import org.mapstruct.Mapper;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;

/**
 * Mapper para convertir entre Hotel (Dominio) y HotelEntity (JPA).
 */
@Mapper(componentModel = "spring")
public interface HotelMapper {
    
    /**
     * Convierte un objeto de dominio a una entidad JPA.
     * @param domain Objeto de dominio.
     * @return Entidad JPA.
     */
    HotelEntity toEntity(Hotel domain);

    /**
     * Convierte una entidad JPA a un objeto de dominio.
     * @param entity Entidad JPA.
     * @return Objeto de dominio.
     */
    Hotel toDomain(HotelEntity entity);
}
