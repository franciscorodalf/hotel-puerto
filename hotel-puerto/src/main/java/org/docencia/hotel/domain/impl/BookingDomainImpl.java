package org.docencia.hotel.domain.impl;

import org.docencia.hotel.domain.api.BookingDomain;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.service.api.BookingService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingDomainImpl implements BookingDomain {

    private final BookingService service;

    public BookingDomainImpl(BookingService service) {
        this.service = service;
    }

    @Override
    public Booking createBooking(Booking booking) {
        return service.createBooking(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return service.getBookingById(id);
    }

    @Override
    public List<Booking> getAllBookings() {
        return service.getAllBookings();
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return service.updateBooking(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        service.deleteBooking(id);
    }
}
