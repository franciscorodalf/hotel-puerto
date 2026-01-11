package org.docencia.hotel.service.impl;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.mapper.jpa.GuestMapper;
import org.docencia.hotel.mapper.nosql.GuestPreferencesMapper;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.docencia.hotel.persistence.repository.jpa.GuestJpaRepository;
import org.docencia.hotel.persistence.repository.nosql.GuestPreferencesRepository;
import org.docencia.hotel.service.api.GuestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementacion del servicio de gestion de huespedes.
 * Maneja la persistencia hibrida (JPA + MongoDB).
 */
@Service
public class GuestServiceImpl implements GuestService {

    private final GuestJpaRepository jpaRepository;
    private final GuestPreferencesRepository mongoRepository;
    private final GuestMapper guestMapper;
    private final GuestPreferencesMapper preferencesMapper;

    /**
     * Constructor con inyeccion de dependencias.
     * @param jpaRepository Repositorio JPA de huespedes.
     * @param mongoRepository Repositorio MongoDB de preferencias.
     * @param guestMapper Mapper de huespedes.
     * @param preferencesMapper Mapper de preferencias.
     */
    public GuestServiceImpl(GuestJpaRepository jpaRepository,
                            GuestPreferencesRepository mongoRepository,
                            GuestMapper guestMapper,
                            GuestPreferencesMapper preferencesMapper) {
        this.jpaRepository = jpaRepository;
        this.mongoRepository = mongoRepository;
        this.guestMapper = guestMapper;
        this.preferencesMapper = preferencesMapper;
    }

    /**
     * Crea un nuevo huesped.
     * Guarda la entidad en JPA y las preferencias en MongoDB.
     * @param guest Objeto de dominio del huesped.
     * @return El huesped creado.
     */
    @Override
    @Transactional
    public Guest createGuest(Guest guest) {
        // 1. Save JPA entity
        GuestEntity entity = guestMapper.toEntity(guest);
        entity = jpaRepository.save(entity);
        
        // 2. Save Mongo document if preferences exist
        if (guest.getPreferences() != null) {
            GuestPreferencesDocument doc = preferencesMapper.toDocument(guest.getPreferences());
            doc.setGuestId(entity.getId()); // Link by ID
            mongoRepository.save(doc);
        }

        return getGuestById(entity.getId());
    }

    /**
     * Obtiene un huesped por su ID.
     * Recupera la informacion basica de JPA y las preferencias de MongoDB.
     * @param id ID del huesped.
     * @return El huesped encontrado o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Guest getGuestById(Long id) {
        return jpaRepository.findById(id)
                .map(entity -> {
                    Guest domain = guestMapper.toDomain(entity);
                    // Fetch preferences from Mongo
                    mongoRepository.findByGuestId(id)
                            .ifPresent(doc -> domain.setPreferences(preferencesMapper.toDomain(doc)));
                    return domain;
                })
                .orElse(null);
    }

    /**
     * Obtiene todos los huespedes.
     * @return Lista de todos los huespedes.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Guest> getAllGuests() {
        return jpaRepository.findAll().stream()
                .map(entity -> {
                    Guest domain = guestMapper.toDomain(entity);
                    mongoRepository.findByGuestId(entity.getId())
                            .ifPresent(doc -> domain.setPreferences(preferencesMapper.toDomain(doc)));
                    return domain;
                })
                .collect(Collectors.toList());
    }

    /**
     * Actualiza un huesped existente.
     * Actualiza tanto en JPA como en MongoDB.
     * @param guest Objeto de dominio del huesped con los datos actualizados.
     * @return El huesped actualizado o null si no existe.
     */
    @Override
    @Transactional
    public Guest updateGuest(Guest guest) {
        if (guest.getId() == null || !jpaRepository.existsById(guest.getId())) {
            return null;
        }
        
        // Update JPA
        GuestEntity entity = guestMapper.toEntity(guest);
        entity = jpaRepository.save(entity);

        // Update Mongo
        if (guest.getPreferences() != null) {
            GuestPreferencesDocument doc = preferencesMapper.toDocument(guest.getPreferences());
            doc.setGuestId(entity.getId());
            // We might need to find existing doc to keep its ID if not provided in input
            mongoRepository.findByGuestId(entity.getId()).ifPresent(existing -> doc.setId(existing.getId()));
            mongoRepository.save(doc);
        } else {
            // If preferences are null, maybe we should delete them? Or just ignore?
            // Let's assume we keep them if not provided, or delete if explicitly null?
            // For simplicity, let's assume we update if provided.
        }

        return getGuestById(entity.getId());
    }

    /**
     * Elimina un huesped por su ID.
     * Elimina tanto de JPA como de MongoDB.
     * @param id ID del huesped a eliminar.
     */
    @Override
    @Transactional
    public void deleteGuest(Long id) {
        jpaRepository.deleteById(id);
        mongoRepository.deleteByGuestId(id);
    }
}
