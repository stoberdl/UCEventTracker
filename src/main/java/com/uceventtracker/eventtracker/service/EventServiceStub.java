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
import java.util.Map;

@Service
public class EventServiceStub implements IEventService {

    @Autowired
    private IEventDAO eventDAO;

    public EventServiceStub(IEventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    public Event fetchEventById(int eventId) {
        Event event = new Event();
        event.setEventID(1);
        event.setTitle("Revolution UC");
        event.setLocation("TUC University of Cincinnati");
        event.setDate("1/1/2021");
        event.setStartTime("11:00am Friday");
        event.setEndTime("11:00am Friday");
        event.setDescription("Hackathon");
        event.setHostName("Major League Hacking");

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
                    event.setEventID(eventId);
                    eventId++;
                    event.setTitle(entry.getTitle());

                    String descriptionData = entry.getDescription().getValue();                       /* gets html text from the description which contains multiple values */
                    descriptionData = descriptionData.replaceAll("\\<[^>]*>", "");  /* removes html from string */
                    descriptionData = descriptionData.replaceAll("  ", "");         /* removes extra spacing */
                    String[] descriptionDataList = descriptionData.split("\\r?\\n");            /* splits by new lines */

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
                    event.setHostName(entry.getAuthor());
                    //TODO: Add and save event to DAO here
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Map<Integer, Event> fetchAll() {
        return eventDAO.fetchAll();
    }
}
