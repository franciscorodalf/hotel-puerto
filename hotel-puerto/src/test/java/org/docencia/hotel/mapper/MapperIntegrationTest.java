package org.docencia.hotel.mapper;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.mapper.jpa.BookingMapper;
import org.docencia.hotel.mapper.jpa.GuestMapper;
import org.docencia.hotel.mapper.jpa.HotelMapper;
import org.docencia.hotel.mapper.jpa.RoomMapper;
import org.docencia.hotel.mapper.nosql.GuestPreferencesMapper;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MapperIntegrationTest {

    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private GuestMapper guestMapper;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private GuestPreferencesMapper guestPreferencesMapper;

    @Test
    void testBookingMapper() {
        Booking booking = new Booking();
        booking.setId(1L);
        BookingEntity entity = bookingMapper.toEntity(booking);
        assertNotNull(entity);
        assertEquals(1L, entity.getId());

        Booking result = bookingMapper.toDomain(entity);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testGuestMapper() {
        Guest guest = new Guest();
        guest.setId(1L);
        guest.setFirstName("John");
        GuestEntity entity = guestMapper.toEntity(guest);
        assertNotNull(entity);
        assertEquals(1L, entity.getId());
        assertEquals("John", entity.getFirstName());

        Guest result = guestMapper.toDomain(entity);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("John", result.getFirstName());
    }

    @Test
    void testHotelMapper() {
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        HotelEntity entity = hotelMapper.toEntity(hotel);
        assertNotNull(entity);
        assertEquals(1L, entity.getId());

        Hotel result = hotelMapper.toDomain(entity);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testRoomMapper() {
        Room room = new Room();
        room.setId(1L);
        RoomEntity entity = roomMapper.toEntity(room);
        assertNotNull(entity);
        assertEquals(1L, entity.getId());

        Room result = roomMapper.toDomain(entity);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testGuestPreferencesMapper() {
        GuestPreferences prefs = new GuestPreferences();
        prefs.setId("abc");
        prefs.setRoomPreference("Suite");
        GuestPreferencesDocument doc = guestPreferencesMapper.toDocument(prefs);
        assertNotNull(doc);
        assertEquals("abc", doc.getId());
        assertEquals("Suite", doc.getRoomPreference());

        GuestPreferences result = guestPreferencesMapper.toDomain(doc);
        assertNotNull(result);
        assertEquals("abc", result.getId());
        assertEquals("Suite", result.getRoomPreference());
    }
}
