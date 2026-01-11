package org.docencia.hotel.service.impl;

import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.mapper.jpa.RoomMapper;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.docencia.hotel.persistence.repository.jpa.RoomRepository;
import org.docencia.hotel.service.api.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementacion del servicio de gestion de habitaciones.
 */
@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;
    private final RoomMapper mapper;

    /**
     * Constructor con inyeccion de dependencias.
     * @param repository Repositorio JPA de habitaciones.
     * @param mapper Mapper de habitaciones.
     */
    public RoomServiceImpl(RoomRepository repository, RoomMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Crea una nueva habitacion.
     * @param room Objeto de dominio de la habitacion.
     * @return La habitacion creada.
     */
    @Override
    @Transactional
    public Room createRoom(Room room) {
        RoomEntity entity = mapper.toEntity(room);
        entity = repository.save(entity);
        return mapper.toDomain(entity);
    }

    /**
     * Obtiene una habitacion por su ID.
     * @param id ID de la habitacion.
     * @return La habitacion encontrada o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Room getRoomById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElse(null);
    }

    /**
     * Obtiene todas las habitaciones.
     * @return Lista de todas las habitaciones.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Room> getAllRooms() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene las habitaciones de un hotel especifico.
     * @param hotelId ID del hotel.
     * @return Lista de habitaciones del hotel.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Room> getRoomsByHotelId(Long hotelId) {
        return repository.findByHotelId(hotelId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    /**
     * Actualiza una habitacion existente.
     * @param room Objeto de dominio de la habitacion con los datos actualizados.
     * @return La habitacion actualizada o null si no existe.
     */
    @Override
    @Transactional
    public Room updateRoom(Room room) {
        if (room.getId() == null || !repository.existsById(room.getId())) {
            return null;
        }
        RoomEntity entity = mapper.toEntity(room);
        entity = repository.save(entity);
        return mapper.toDomain(entity);
    }

    /**
     * Elimina una habitacion por su ID.
     * @param id ID de la habitacion a eliminar.
     */
    @Override
    @Transactional
    public void deleteRoom(Long id) {
        repository.deleteById(id);
    }
}
