package com.uceventtracker.eventtracker.service;

import com.uceventtracker.eventtracker.dao.IEventDAO;
import com.uceventtracker.eventtracker.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceStub implements IEventService {
    @Autowired
    private IEventDAO eventDAO;

    public EventServiceStub() {

    }

    public EventServiceStub(IEventDAO eventDAO) {

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

    public static void loadRSS() {

        try {
            String url = "https://campuslink.uc.edu/events.rss";

            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed feed = new SyndFeedInput().build(reader);

                int eventId = 1;
                for (SyndEntry entry : feed.getEntries()) {

                    Event event = new Event();
                    event.setEventId(eventId);
                    eventId++;
                    event.setTitle(entry.getTitle());

                    String descriptionData = entry.getDescription().getValue();                      /* get html text from the description which contains multiple values */
                    descriptionData = descriptionData.replaceAll("\\<[^>]*>", "");   /* remove html from string */
                    descriptionData = descriptionData.replaceAll("  ", "");          /* remove extra spacing */
                    String[] descriptionDataList = descriptionData.split("\\r?\\n");           /* split by new lines */

                    boolean saveNextLine = false;
                    String description = "";

                    for (String i : descriptionDataList) {
                        System.out.println(i);
                        if (i.startsWith(entry.getTitle())) {
                            saveNextLine = true;
                        } else if (i.startsWith("From")) {
                            saveNextLine = false;
                            i = i.replace("From ", "");
                            event.setStartTime(i);
                        } else if (saveNextLine) {
                            description = description + i;
                        } else if (i.startsWith("to")) {
                            i = i.replace("to ", "");
                            event.setEndTime(i);
                        } else if (i.startsWith("at")) {
                            i = i.replace("at ", "");
                            i = i.replace(".", "");
                            event.setLocation(i);
                        }

                    }
                    event.setDescription(description);
                    event.setHost(entry.getAuthor());

                    //add and save event to dao here
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Event> fetchAllEvents() {

        return eventDAO.fetchAllEvents();
    }
}
