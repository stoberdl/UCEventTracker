package com.uceventtracker.eventtracker.service;

import com.uceventtracker.eventtracker.dto.Event;
import org.springframework.stereotype.Component;

@Component
public class EventServiceStub implements IEventService{
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
}
