package org.docencia.hotel.domain.impl;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.service.api.GuestService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GuestDomainImpl implements GuestDomain {

    private final GuestService service;

    public GuestDomainImpl(GuestService service) {
        this.service = service;
    }

    @Override
    public Guest createGuest(Guest guest) {
        return service.createGuest(guest);
    }

    @Override
    public Guest getGuestById(Long id) {
        return service.getGuestById(id);
    }

    @Override
    public List<Guest> getAllGuests() {
        return service.getAllGuests();
    }

    @Override
    public Guest updateGuest(Guest guest) {
        return service.updateGuest(guest);
    }

    @Override
    public void deleteGuest(Long id) {
        service.deleteGuest(id);
    }
}
