package org.docencia.hotel.domain.impl;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.service.api.GuestService;
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
class GuestDomainImplTest {

    @Mock
    private GuestService service;

    @InjectMocks
    private GuestDomainImpl domain;

    @Test
    void createGuest_ShouldDelegateToService() {
        Guest guest = new Guest();
        when(service.createGuest(guest)).thenReturn(guest);
        Guest result = domain.createGuest(guest);
        assertEquals(guest, result);
        verify(service).createGuest(guest);
    }

    @Test
    void getGuestById_ShouldDelegateToService() {
        Long id = 1L;
        Guest guest = new Guest();
        when(service.getGuestById(id)).thenReturn(guest);
        Guest result = domain.getGuestById(id);
        assertEquals(guest, result);
        verify(service).getGuestById(id);
    }

    @Test
    void getAllGuests_ShouldDelegateToService() {
        List<Guest> list = Collections.emptyList();
        when(service.getAllGuests()).thenReturn(list);
        List<Guest> result = domain.getAllGuests();
        assertEquals(list, result);
        verify(service).getAllGuests();
    }

    @Test
    void updateGuest_ShouldDelegateToService() {
        Guest guest = new Guest();
        when(service.updateGuest(guest)).thenReturn(guest);
        Guest result = domain.updateGuest(guest);
        assertEquals(guest, result);
        verify(service).updateGuest(guest);
    }

    @Test
    void deleteGuest_ShouldDelegateToService() {
        Long id = 1L;
        domain.deleteGuest(id);
        verify(service).deleteGuest(id);
    }
}
