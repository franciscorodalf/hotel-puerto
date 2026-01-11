package org.docencia.hotel.service.impl;

import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.mapper.jpa.HotelMapper;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.repository.jpa.HotelRepository;
import org.docencia.hotel.service.api.HotelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;
    private final HotelMapper mapper;

    /**
     * Constructor con inyeccion de dependencias.
     * @param repository Repositorio JPA de hoteles.
     * @param mapper Mapper de hoteles.
     */
    public HotelServiceImpl(HotelRepository repository, HotelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Crea un nuevo hotel.
     * @param hotel Objeto de dominio del hotel.
     * @return El hotel creado.
     */
    @Override
    @Transactional
    public Hotel createHotel(Hotel hotel) {
        HotelEntity entity = mapper.toEntity(hotel);
        entity = repository.save(entity);
        return mapper.toDomain(entity);
    }

    /**
     * Obtiene un hotel por su ID.
     * @param id ID del hotel.
     * @return El hotel encontrado o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Hotel getHotelById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElse(null);
    }

    /**
     * Obtiene todos los hoteles.
     * @return Lista de todos los hoteles.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Hotel> getAllHotels() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    /**
     * Actualiza un hotel existente.
     * @param hotel Objeto de dominio del hotel con los datos actualizados.
     * @return El hotel actualizado o null si no existe.
     */
    @Override
    @Transactional
    public Hotel updateHotel(Hotel hotel) {
        if (hotel.getId() == null || !repository.existsById(hotel.getId())) {
            return null;
        }
        HotelEntity entity = mapper.toEntity(hotel);
        entity = repository.save(entity);
        return mapper.toDomain(entity);
    }

    /**
     * Elimina un hotel por su ID.
     * @param id ID del hotel a eliminar.
     */
    @Override
    @Transactional
    public void deleteHotel(Long id) {
        repository.deleteById(id);
    }
}
