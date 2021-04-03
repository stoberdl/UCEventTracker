package com.uceventtracker.eventtracker;

import com.uceventtracker.eventtracker.dao.IEventDAO;
import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.service.IEventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EventTrackerApplicationTests {

    @Autowired
    private IEventDAO eventDAO;
    private List<Event> allEvents;
    private List<Event> matchingEvents;

    @Autowired
    private IEventService eventService;

    Event event1 = new Event();
    Event event2 = new Event();
    Event event3 = new Event();

    @Test
    void checkEventData() throws Exception {
        givenEventData();
        whenEventTitleHack();
        thenViewEventData();
    }

    @Test
    void fetchAllEvents() throws Exception {
        givenEventData();
        whenEventDataIsLoaded();
        thenDisplayListOfEvents();
    }


    private void givenEventData() throws Exception {
        event1.setTitle("UC Hackathon");
        event1.setLocation("Crosley tower");
        try {
            event1.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("23-01-2021"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        event1.setStartTime("1pm");
        event1.setEndTime("5pm");
        event1.setDescription("Groups compete to solve problems");
        event1.setHost("CECH");
        eventDAO.save(event1);

        event2.setTitle("Knitting");
        event2.setLocation("Wheelbarrow tower");
        try {
            event2.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("6-01-2021"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        event2.setStartTime("3pm");
        event2.setEndTime("4pm");
        event2.setDescription("Groups compete to knit");
        event2.setHost("Knitting Club");
        eventDAO.save(event2);

        event3.setTitle("Preventing Hacks");
        event3.setLocation("Mcdonalds");
        try {
            event3.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("25-02-2021"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        event3.setStartTime("12pm");
        event3.setEndTime("2pm");
        event3.setDescription("Learn about ways to prevent hackers from accessing your data.");
        event3.setHost("CECH");
        eventDAO.save(event3);
    }

    private void whenEventTitleHack() {

        matchingEvents = eventService.fetchEventsByTitle("Hack");

    }

    private void thenViewEventData() {

        for(Event e : matchingEvents){
            System.out.println( e.getTitle() + "\n " + e.getDescription()+ "\n " + e.getLocation() + "\n " + e.getStartTime() + "\n " + e.getEndTime() + "\n " + e.getHost() + "\n******************************************");
        }

        assertEquals("Preventing Hacks", matchingEvents.get(0).getTitle());
        assertEquals("UC Hackathon", matchingEvents.get(1).getTitle());
    }

    private void whenEventDataIsLoaded() {
        allEvents = eventService.fetchAllEvents();
    }

    private void thenDisplayListOfEvents() {
        assertEquals(3, allEvents.size());
    }

    @Test
    void sortEventsByDate() throws Exception {
        givenEventData();
        whenEventsFetched();
        thenReturnEventsSortedByDate();
    }

    private void whenEventsFetched() {
        allEvents = eventDAO.fetchAllEvents();
    }

    private void thenReturnEventsSortedByDate() {
        List<Date> eventDates = new ArrayList();
        for (Event e : allEvents) {
            eventDates.add(e.getDate());
        }
        Collections.sort(eventDates);

        assertEquals(event2.getDate(), eventDates.get(0));
    }
}
