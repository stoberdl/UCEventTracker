package com.uceventtracker.eventtracker.service;

import com.uceventtracker.eventtracker.dao.IEventDAO;
import com.uceventtracker.eventtracker.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class EventService implements IEventService {
    @Autowired
    private IEventDAO eventDAO;

    @Override
    public List<Event> fetchEventsByTitle(String title) {
        List<Event> allEvents = eventDAO.fetchAllEvents();
        List<Event> matchingEvents = new ArrayList<>();
        for (Event event: allEvents) {
            if(event.getTitle().contains(title)){
                matchingEvents.add(event);
            }
        }

        return matchingEvents;
    }

    @Override
    public List<Event> fetchAllEvents() {

        return eventDAO.fetchAllEvents();
    }

    @Override
    public List<Event> fetchRssEvents(){
        List<Event> allEvents = new ArrayList<>();
        ArrayList<String> eventInfo = loadRSS();

        //assert that the eventInfo is not null to avoid null exceptions
        assert eventInfo != null;
        for(String i : eventInfo){
            Event event = new Event();

            String title = i.substring(i.indexOf("<title>")+7, i.indexOf("</title>"));
            String description = i.substring(i.indexOf("<description>")+13, i.indexOf("</description>"));
            description = description.substring(description.indexOf("p-description description")+27, description.indexOf("<div>    <p>"));
            description = description.replaceAll("<[^>]*>", "");
            description = description.replaceAll("&nbsp;", "");
            String location = i.substring(i.indexOf("<location>")+10, i.indexOf("</location>"));
            String start = i.substring(i.indexOf("<start>")+7, i.indexOf("</start>"));
            String end = i.substring(i.indexOf("<end>")+5, i.indexOf("</end>"));
            String host = i.substring(i.indexOf("<host>")+6, i.indexOf("</host>"));

            event.setTitle(title);
            event.setDescription(description);
            event.setLocation(location);
            event.setLocation(location);
            event.setStartTime(start);
            event.setEndTime(end);
            event.setHost(host);
            eventDAO.save(event);
            allEvents.add(event);
        }

        return allEvents;
    }

    private ArrayList<String> loadRSS() {
        ArrayList<String> eventInfo = new ArrayList<>();

        try{
            URL url = new URL("https://campuslink.uc.edu/events.rss");
            Scanner in = new Scanner(new InputStreamReader(url.openStream()));
            StringBuilder data = new StringBuilder();

            while(in.hasNext()){
                data.append(in.nextLine());
            }

            data = new StringBuilder(data.substring(data.indexOf("<item>")));
            String[] temp = data.toString().split("</item>");

            eventInfo.addAll(Arrays.asList(temp));

            eventInfo.remove(eventInfo.size()-1);
            return eventInfo;
        } catch (IOException e) {
            //collapse catch blocks for readability
            e.printStackTrace();
        }

        return null;
    }


}
