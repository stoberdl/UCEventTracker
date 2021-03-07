package com.uceventtracker.eventtracker.service;

import com.uceventtracker.eventtracker.dto.Event;

import java.util.List;

public interface IEventService {
    /*
    *Fetch an event when an id param is passed.
    * @param eventId
    * @return event with the same event id or null if no matches found.
    */
    Event fetchEventById(int eventId);

    List<Event> fetchAllEvents();
}
