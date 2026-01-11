package org.docencia.hotel.mapper.jpa;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;

/**
 * Mapper para convertir entre Booking (Dominio) y BookingEntity (JPA).
 */
@Mapper(componentModel = "spring")
public interface BookingMapper {
    
    /**
     * Convierte un objeto de dominio a una entidad JPA.
     * @param domain Objeto de dominio.
     * @return Entidad JPA.
     */
    @Mapping(source = "roomId", target = "room.id")
    @Mapping(source = "guestId", target = "guest.id")
    BookingEntity toEntity(Booking domain);

    /**
     * Convierte una entidad JPA a un objeto de dominio.
     * @param entity Entidad JPA.
     * @return Objeto de dominio.
     */
    @Mapping(source = "room.id", target = "roomId")
    @Mapping(source = "guest.id", target = "guestId")
    Booking toDomain(BookingEntity entity);
}
