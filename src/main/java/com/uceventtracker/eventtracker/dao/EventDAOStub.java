package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Event;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("test")
public class EventDAOStub implements IEventDAO{
    List<Event> allEvents = new ArrayList<>();

    @Override
    public List<Event> fetchAllEvents() {
        return allEvents;
    }

    @Override
    public Event save(Event event) {
        allEvents.add(event);
        return event;
    }
}