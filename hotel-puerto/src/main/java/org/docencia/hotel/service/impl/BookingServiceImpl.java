package org.docencia.hotel.service.impl;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.mapper.jpa.BookingMapper;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.docencia.hotel.persistence.repository.jpa.BookingRepository;
import org.docencia.hotel.service.api.BookingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;
    private final BookingMapper mapper;

    /**
     * Constructor con inyeccion de dependencias.
     * @param repository Repositorio JPA de reservas.
     * @param mapper Mapper de reservas.
     */
    public BookingServiceImpl(BookingRepository repository, BookingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Crea una nueva reserva.
     * @param booking Objeto de dominio de la reserva.
     * @return La reserva creada.
     */
    @Override
    @Transactional
    public Booking createBooking(Booking booking) {
        BookingEntity entity = mapper.toEntity(booking);
        entity = repository.save(entity);
        return mapper.toDomain(entity);
    }

    /**
     * Obtiene una reserva por su ID.
     * @param id ID de la reserva.
     * @return La reserva encontrada o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Booking getBookingById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElse(null);
    }

    /**
     * Obtiene todas las reservas.
     * @return Lista de todas las reservas.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Booking> getAllBookings() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    /**
     * Actualiza una reserva existente.
     * @param booking Objeto de dominio de la reserva con los datos actualizados.
     * @return La reserva actualizada o null si no existe.
     */
    @Override
    @Transactional
    public Booking updateBooking(Booking booking) {
        if (booking.getId() == null || !repository.existsById(booking.getId())) {
            return null;
        }
        BookingEntity entity = mapper.toEntity(booking);
        entity = repository.save(entity);
        return mapper.toDomain(entity);
    }

    /**
     * Elimina una reserva por su ID.
     * @param id ID de la reserva a eliminar.
     */
    @Override
    @Transactional
    public void deleteBooking(Long id) {
        repository.deleteById(id);
    }
}
