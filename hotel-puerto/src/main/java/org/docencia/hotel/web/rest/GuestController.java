package org.docencia.hotel.web.rest;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Guests", description = "Operaciones REST de huéspedes")
@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestDomain guestDomain;

    /**
     * Constructor con inyeccion de dependencias.
     * @param guestDomain Dominio de huespedes.
     */
    public GuestController(GuestDomain guestDomain) {
        this.guestDomain = guestDomain;
    }

    /**
     * Obtiene un huesped por su ID.
     * @param id ID del huesped.
     * @return ResponseEntity con el huesped encontrado o 404 si no existe.
     */
    @Operation(summary = "Obtener huésped por id")
    @GetMapping("/{id}")
    public ResponseEntity<Guest> findById(@PathVariable Long id) {
        Guest guest = guestDomain.getGuestById(id);
        if (guest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(guest);
    }

    /**
     * Obtiene todos los huespedes.
     * @return ResponseEntity con la lista de todos los huespedes.
     */
    @Operation(summary = "Obtener todos los huéspedes")
    @GetMapping
    public ResponseEntity<List<Guest>> findAll() {
        return ResponseEntity.ok(guestDomain.getAllGuests());
    }

    /**
     * Guarda un nuevo huesped.
     * @param guest Objeto de dominio del huesped a guardar.
     * @return ResponseEntity con el huesped guardado.
     */
    @Operation(summary = "Guardar huésped")
    @PostMapping
    public ResponseEntity<Guest> save(@Valid @RequestBody Guest guest) {
        return ResponseEntity.ok(guestDomain.createGuest(guest));
    }

    /**
     * Actualiza un huesped existente.
     * @param id ID del huesped a actualizar.
     * @param guest Objeto de dominio del huesped con los datos actualizados.
     * @return ResponseEntity con el huesped actualizado o 404 si no existe.
     */
    @Operation(summary = "Actualizar huésped")
    @PutMapping("/{id}")
    public ResponseEntity<Guest> update(@PathVariable Long id, @Valid @RequestBody Guest guest) {
        guest.setId(id);
        Guest updated = guestDomain.updateGuest(guest);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    /**
     * Elimina un huesped por su ID.
     * @param id ID del huesped a eliminar.
     * @return ResponseEntity con 204 No Content.
     */
    @Operation(summary = "Eliminar huésped")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        guestDomain.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}
