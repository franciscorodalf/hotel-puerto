package org.docencia.hotel.service.api;

import org.docencia.hotel.domain.model.Hotel;
import java.util.List;

/**
 * Servicio para la gestion de hoteles.
 */
public interface HotelService {
    /**
     * Crea un nuevo hotel.
     * @param hotel Hotel a crear.
     * @return Hotel creado.
     */
    Hotel createHotel(Hotel hotel);

    /**
     * Obtiene un hotel por su ID.
     * @param id ID del hotel.
     * @return Hotel encontrado.
     */
    Hotel getHotelById(Long id);

    /**
     * Obtiene todos los hoteles.
     * @return Lista de hoteles.
     */
    List<Hotel> getAllHotels();

    /**
     * Actualiza un hotel existente.
     * @param hotel Hotel con datos actualizados.
     * @return Hotel actualizado.
     */
    Hotel updateHotel(Hotel hotel);

    /**
     * Elimina un hotel por su ID.
     * @param id ID del hotel a eliminar.
     */
    void deleteHotel(Long id);
}
