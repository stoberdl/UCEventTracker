package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Event;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IEventDAO {
    /**
     * Save a new Skate Spot
     * //@param //SkateSpotDTO the entry to save.
     */
    void save(Event event);
    List<Event> fetchAllEvents();
}
