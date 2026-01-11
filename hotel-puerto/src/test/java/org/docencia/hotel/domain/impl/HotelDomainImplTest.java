package org.docencia.hotel.domain.impl;

import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.service.api.HotelService;
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
class HotelDomainImplTest {

    @Mock
    private HotelService service;

    @InjectMocks
    private HotelDomainImpl domain;

    @Test
    void createHotel_ShouldDelegateToService() {
        Hotel hotel = new Hotel();
        when(service.createHotel(hotel)).thenReturn(hotel);
        Hotel result = domain.createHotel(hotel);
        assertEquals(hotel, result);
        verify(service).createHotel(hotel);
    }

    @Test
    void getHotelById_ShouldDelegateToService() {
        Long id = 1L;
        Hotel hotel = new Hotel();
        when(service.getHotelById(id)).thenReturn(hotel);
        Hotel result = domain.getHotelById(id);
        assertEquals(hotel, result);
        verify(service).getHotelById(id);
    }

    @Test
    void getAllHotels_ShouldDelegateToService() {
        List<Hotel> list = Collections.emptyList();
        when(service.getAllHotels()).thenReturn(list);
        List<Hotel> result = domain.getAllHotels();
        assertEquals(list, result);
        verify(service).getAllHotels();
    }

    @Test
    void updateHotel_ShouldDelegateToService() {
        Hotel hotel = new Hotel();
        when(service.updateHotel(hotel)).thenReturn(hotel);
        Hotel result = domain.updateHotel(hotel);
        assertEquals(hotel, result);
        verify(service).updateHotel(hotel);
    }

    @Test
    void deleteHotel_ShouldDelegateToService() {
        Long id = 1L;
        domain.deleteHotel(id);
        verify(service).deleteHotel(id);
    }
}
