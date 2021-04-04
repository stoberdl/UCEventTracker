package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Event;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
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
