package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Date;
import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.dto.Host;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EventDAOStub implements IEventDAO{

    private Map<Integer, Event> events = new HashMap<>();

    /**
     * Method for creating a new Event record
     */
    @Override
    public boolean createEvent(Event event) {
        events.put(event.getEventID(), event);
        if (events.containsKey(event.getEventID())) return true;

        return false;
    }

    /**
     * Method for fetching a list of the event titles
     * @param title
     */
    @Override
    public List<Event> fetchByTitle(String title) {
        List<Event> titleList = new ArrayList<>(events.values());
        List<Event> requiredTitles = new ArrayList<>();

        for (Event cTitle : titleList) {
            if (cTitle.getTitle().equals(title)) {
                requiredTitles.add(cTitle);
            }
        }

        return requiredTitles;
    }

    /**
     * Method for fetching events by HostName
     * @param hostID tied to chosen hostID to draw events
     */
    @Override
    public Event fetchByHostName(int hostID) {
        List<Event> eventList = new ArrayList<>(events.values());
        Event chooseEvent = new Event();

        for (Event event : eventList) {
            if (event.getHostID() == hostID) {
                chooseEvent = event;
            }
        }

        return chooseEvent;
    }

    /**
     * Method for fetching events by date
     * @param date tied to chosen date to draw events
     */
    @Override
    public Event fetchByDate(String date) {
        List<Event> eventList = new ArrayList<>(events.values());
        Event chooseEvent = new Event();

        for (Event event : eventList) {
            if (event.getDate().equals(event)) {
                chooseEvent = event;
            }
        }

        return chooseEvent;
    }

    /**
     * Method for fetching all events
     */
    @Override
    public Map<Integer, Event> fetchAll() { return events; }
}
