package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile({"dev", "default"})
public class EventSQLDAO implements IEventDAO {

    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Event> fetchAllEvents() {
        List<Event> allEvents = new ArrayList<>();
        Iterable<Event> events = eventRepository.findAll();
        for (Event event : events) {
            allEvents.add(event);
        }
        return allEvents;
    }

    @Override
    public Event save(Event event) throws Exception {
        Event createdEvent = (Event) eventRepository.save(event);
        return createdEvent;
    }
}
