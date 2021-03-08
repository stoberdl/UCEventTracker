package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Date;
import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.dto.Host;

import java.util.List;
import java.util.Map;

/**
 * Data Access Object Interface for Events
 * <p>
 *     Gives access to Event data
 * </p>
 */
public interface IEventDAO {

    boolean createEvent(Event event);

    List<Event> fetchByTitle(String title);

    Event fetchByHostName(int hostID);

    Event fetchByDate(String date);

    Map<Integer,Event> fetchAll();
}
