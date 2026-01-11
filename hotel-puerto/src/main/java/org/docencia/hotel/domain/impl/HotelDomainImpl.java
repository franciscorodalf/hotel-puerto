package org.docencia.hotel.domain.impl;

import org.docencia.hotel.domain.api.HotelDomain;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.service.api.HotelService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelDomainImpl implements HotelDomain {

    private final HotelService service;

    public HotelDomainImpl(HotelService service) {
        this.service = service;
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return service.createHotel(hotel);
    }

    @Override
    public Hotel getHotelById(Long id) {
        return service.getHotelById(id);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return service.getAllHotels();
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return service.updateHotel(hotel);
    }

    @Override
    public void deleteHotel(Long id) {
        service.deleteHotel(id);
    }
}
