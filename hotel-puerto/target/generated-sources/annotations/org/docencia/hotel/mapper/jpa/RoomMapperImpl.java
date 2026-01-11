package org.docencia.hotel.mapper.jpa;

import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-11T01:14:41+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260101-2150, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public RoomEntity toEntity(Room domain) {
        if ( domain == null ) {
            return null;
        }

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.setHotel( roomToHotelEntity( domain ) );
        roomEntity.setId( domain.getId() );
        roomEntity.setNumber( domain.getNumber() );
        roomEntity.setType( domain.getType() );
        roomEntity.setPrice( domain.getPrice() );
        roomEntity.setAvailable( domain.getAvailable() );

        return roomEntity;
    }

    @Override
    public Room toDomain(RoomEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Room room = new Room();

        room.setHotelId( entityHotelId( entity ) );
        room.setId( entity.getId() );
        room.setNumber( entity.getNumber() );
        room.setType( entity.getType() );
        room.setPrice( entity.getPrice() );
        room.setAvailable( entity.getAvailable() );

        return room;
    }

    protected HotelEntity roomToHotelEntity(Room room) {
        if ( room == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setId( room.getHotelId() );

        return hotelEntity;
    }

    private Long entityHotelId(RoomEntity roomEntity) {
        if ( roomEntity == null ) {
            return null;
        }
        HotelEntity hotel = roomEntity.getHotel();
        if ( hotel == null ) {
            return null;
        }
        Long id = hotel.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
