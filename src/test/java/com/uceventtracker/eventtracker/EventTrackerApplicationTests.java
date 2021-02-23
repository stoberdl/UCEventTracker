package com.uceventtracker.eventtracker;

import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.service.IEventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventTrackerApplicationTests {

    @Autowired
    private IEventService eventService;
    private Event event;

    @Test
    void contextLoads() {
    }

    @Test
    void checkEventData(){
        givenEventDataIsAvailable();
        whenEventDataIsLoaded();
        thenViewEventData();
    }

    private void givenEventDataIsAvailable() {
    }

    private void whenEventDataIsLoaded() {
        event = eventService.fetchEventById(1);
    }

    private void thenViewEventData() {
        System.out.println(event.getTitle());
        System.out.println(event.getLocation());
        System.out.println(event.getStartTime());
        System.out.println(event.getEndTime());
        System.out.println(event.getDescription());
        System.out.println(event.getHost());
    }
}
