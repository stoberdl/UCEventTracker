package com.uceventtracker.eventtracker;

import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.service.IEventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class EventTrackerApplicationTests {
    private List<Event> allEvents;

    @Autowired
    private IEventService eventService;
    private Event event;

    @Test
    void contextLoads() {
    }

    @Test
    void checkEventData(){
        givenEventDataIsAvailable();
        whenEventIsSearchedWithId();
        thenViewEventData();
    }

    @Test
    void fetchAllEvents(){
        givenEventDataIsAvailable();
        whenEventDataIsLoaded();
        thenDisplayListOfEvents();
    }

    @Test
    void readRSSEventsFeed(){


    }

    private void givenEventDataIsAvailable() {
    }

    private void whenEventIsSearchedWithId() {
        event = eventService.fetchEventById(1);
    }

    private void thenViewEventData() {
        System.out.println(event.getEventTitle());
        System.out.println(event.getEventLocation());
        System.out.println(event.getStartTime());
        System.out.println(event.getEndTime());
        System.out.println(event.getEventDescription());
        System.out.println(event.getEventHost());
    }

    private void whenEventDataIsLoaded() {
    }

    private void thenDisplayListOfEvents() {
        allEvents = eventService.fetchAllEvents();
    }
}
