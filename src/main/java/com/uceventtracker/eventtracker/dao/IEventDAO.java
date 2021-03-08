package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Event;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IEventDAO {
    /**
     * Save a new Event
     * //@param //Event the entry to save.
     */
    void save(Event event);
    /**
     * Return all events
     * //@return a collection of all events.
     */
    List<Event> fetchAllEvents();
}
