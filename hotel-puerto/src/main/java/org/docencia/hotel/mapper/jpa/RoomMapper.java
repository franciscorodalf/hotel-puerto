package org.docencia.hotel.mapper.jpa;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;


@Mapper(componentModel = "spring")
public interface RoomMapper {
    
    /**
     * Convierte un objeto de dominio a una entidad JPA.
     * @param domain Objeto de dominio.
     * @return Entidad JPA.
     */
    @Mapping(source = "hotelId", target = "hotel.id")
    RoomEntity toEntity(Room domain);

    /**
     * Convierte una entidad JPA a un objeto de dominio.
     * @param entity Entidad JPA.
     * @return Objeto de dominio.
     */
    @Mapping(source = "hotel.id", target = "hotelId")
    Room toDomain(RoomEntity entity);
}
