package org.docencia.hotel.service.api;

import org.docencia.hotel.domain.model.Room;
import java.util.List;


public interface RoomService {
    /**
     * Crea una nueva habitacion.
     * @param room Habitacion a crear.
     * @return Habitacion creada.
     */
    Room createRoom(Room room);

    /**
     * Obtiene una habitacion por su ID.
     * @param id ID de la habitacion.
     * @return Habitacion encontrada.
     */
    Room getRoomById(Long id);

    /**
     * Obtiene todas las habitaciones.
     * @return Lista de habitaciones.
     */
    List<Room> getAllRooms();

    /**
     * Obtiene las habitaciones de un hotel especifico.
     * @param hotelId ID del hotel.
     * @return Lista de habitaciones del hotel.
     */
    List<Room> getRoomsByHotelId(Long hotelId);

    /**
     * Actualiza una habitacion existente.
     * @param room Habitacion con datos actualizados.
     * @return Habitacion actualizada.
     */
    Room updateRoom(Room room);

    /**
     * Elimina una habitacion por su ID.
     * @param id ID de la habitacion a eliminar.
     */
    void deleteRoom(Long id);
}
