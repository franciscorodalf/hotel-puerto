package org.docencia.hotel.domain.impl;

import org.docencia.hotel.domain.api.RoomDomain;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.service.api.RoomService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomDomainImpl implements RoomDomain {

    private final RoomService service;

    public RoomDomainImpl(RoomService service) {
        this.service = service;
    }

    @Override
    public Room createRoom(Room room) {
        return service.createRoom(room);
    }

    @Override
    public Room getRoomById(Long id) {
        return service.getRoomById(id);
    }

    @Override
    public List<Room> getAllRooms() {
        return service.getAllRooms();
    }

    @Override
    public List<Room> getRoomsByHotelId(Long hotelId) {
        return service.getRoomsByHotelId(hotelId);
    }

    @Override
    public Room updateRoom(Room room) {
        return service.updateRoom(room);
    }

    @Override
    public void deleteRoom(Long id) {
        service.deleteRoom(id);
    }
}
