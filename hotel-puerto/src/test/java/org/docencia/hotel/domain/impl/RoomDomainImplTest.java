package org.docencia.hotel.domain.impl;

import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.service.api.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoomDomainImplTest {

    @Mock
    private RoomService service;

    @InjectMocks
    private RoomDomainImpl domain;

    @Test
    void createRoom_ShouldDelegateToService() {
        Room room = new Room();
        when(service.createRoom(room)).thenReturn(room);
        Room result = domain.createRoom(room);
        assertEquals(room, result);
        verify(service).createRoom(room);
    }

    @Test
    void getRoomById_ShouldDelegateToService() {
        Long id = 1L;
        Room room = new Room();
        when(service.getRoomById(id)).thenReturn(room);
        Room result = domain.getRoomById(id);
        assertEquals(room, result);
        verify(service).getRoomById(id);
    }

    @Test
    void getAllRooms_ShouldDelegateToService() {
        List<Room> list = Collections.emptyList();
        when(service.getAllRooms()).thenReturn(list);
        List<Room> result = domain.getAllRooms();
        assertEquals(list, result);
        verify(service).getAllRooms();
    }

    @Test
    void updateRoom_ShouldDelegateToService() {
        Room room = new Room();
        when(service.updateRoom(room)).thenReturn(room);
        Room result = domain.updateRoom(room);
        assertEquals(room, result);
        verify(service).updateRoom(room);
    }

    @Test
    void deleteRoom_ShouldDelegateToService() {
        Long id = 1L;
        domain.deleteRoom(id);
        verify(service).deleteRoom(id);
    }
}
