package br.com.infracommerce.inscription;

import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by ifc.vinicius.saraiva on 21/08/17.
 */
@Component
public class BeforeSaveEventListener extends AbstractRepositoryEventListener {

    @Autowired
    com.google.api.services.calendar.Calendar service;

    @Override
    public void onBeforeCreate(Object entity) {


        Event event = null;
        try {
            event = service.events().get("primary", "6c5phff4lkm4tp3tlvmv25lq1n").execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(event.getAttendees());
        final EventAttendee eventAttendee = new EventAttendee();
        eventAttendee.setEmail(((Inscription)entity).getEmail());
        final List<EventAttendee> eventAttendees = event.getAttendees();
        eventAttendees.add(eventAttendee);
        event.setAttendees(eventAttendees);
        Event updateEvent = null;
        try {
            updateEvent = service.events().update("primary", "6c5phff4lkm4tp3tlvmv25lq1n", event).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(updateEvent.getAttendees());
    }
}
