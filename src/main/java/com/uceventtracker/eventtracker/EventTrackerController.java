package com.uceventtracker.eventtracker;

import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventTrackerController {
    @Autowired
    IEventService eventService;

    /**
     * Handle the / endpoint
     * @return start.html
     */
    @RequestMapping("/")
    public String index(Model model) throws Exception {
        List<Event> allEvents;
        Event event = new Event();
        event.setTitle("UC Hackathon");
        event.setLocation("Crosley tower");
        event.setStartTime("1pm");
        event.setEndTime("5pm");
        event.setDescription("Groups compete to solve problems");
        event.setHost("CECH");
        model.addAttribute(event);

        allEvents = eventService.fetchRssEvents();

        for(Event e : allEvents){
            System.out.println( e.getTitle() + "\n " + e.getDescription()+ "\n " + e.getLocation() + "\n " + e.getStartTime() + "\n " + e.getEndTime() + "\n " + e.getHost() + "\n******************************************");
        }

        return "start";
    }


}