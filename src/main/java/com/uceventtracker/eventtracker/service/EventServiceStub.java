package com.uceventtracker.eventtracker.service;

import com.uceventtracker.eventtracker.dao.IEventDAO;
import com.uceventtracker.eventtracker.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceStub implements IEventService{
    @Autowired
    private IEventDAO eventDAO;

    public EventServiceStub(){

    }

    public EventServiceStub(IEventDAO eventDAO){
        this.eventDAO = eventDAO;
    }

    @Override
    public Event fetchEventById(int eventId) {
        Event event = new Event();
        event.setEventId(1);
        event.setTitle("Revolution UC");
        event.setStartTime("11:00am Friday");
        event.setEndTime("11:00am Friday");
        event.setDescription("Hackathon");
        event.setHost("Major League Hacking");

        return event;
    }

    @Override
    public List<Event> fetchAllEvents() {
        return eventDAO.fetchAllEvents();
    }
}
