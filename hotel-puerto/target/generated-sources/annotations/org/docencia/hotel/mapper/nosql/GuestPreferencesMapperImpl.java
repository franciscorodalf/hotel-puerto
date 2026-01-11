package org.docencia.hotel.mapper.nosql;

import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-11T10:15:12+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260101-2150, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class GuestPreferencesMapperImpl implements GuestPreferencesMapper {

    @Override
    public GuestPreferencesDocument toDocument(GuestPreferences domain) {
        if ( domain == null ) {
            return null;
        }

        GuestPreferencesDocument guestPreferencesDocument = new GuestPreferencesDocument();

        guestPreferencesDocument.setId( domain.getId() );
        guestPreferencesDocument.setDietaryRequirements( domain.getDietaryRequirements() );
        guestPreferencesDocument.setRoomPreference( domain.getRoomPreference() );
        guestPreferencesDocument.setSpecialRequests( domain.getSpecialRequests() );

        return guestPreferencesDocument;
    }

    @Override
    public GuestPreferences toDomain(GuestPreferencesDocument doc) {
        if ( doc == null ) {
            return null;
        }

        GuestPreferences guestPreferences = new GuestPreferences();

        guestPreferences.setId( doc.getId() );
        guestPreferences.setDietaryRequirements( doc.getDietaryRequirements() );
        guestPreferences.setRoomPreference( doc.getRoomPreference() );
        guestPreferences.setSpecialRequests( doc.getSpecialRequests() );

        return guestPreferences;
    }
}
