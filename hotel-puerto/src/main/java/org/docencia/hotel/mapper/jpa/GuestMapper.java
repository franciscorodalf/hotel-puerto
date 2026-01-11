package org.docencia.hotel.mapper.jpa;

import org.mapstruct.Mapper;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;


@Mapper(componentModel = "spring")
public interface GuestMapper {
    
    /**
     * Convierte un objeto de dominio a una entidad JPA.
     * @param domain Objeto de dominio.
     * @return Entidad JPA.
     */
    GuestEntity toEntity(Guest domain);

    /**
     * Convierte una entidad JPA a un objeto de dominio.
     * @param entity Entidad JPA.
     * @return Objeto de dominio.
     */
    Guest toDomain(GuestEntity entity);
}
