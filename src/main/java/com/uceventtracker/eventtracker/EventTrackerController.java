package com.uceventtracker.eventtracker;

import com.uceventtracker.eventtracker.dao.IEventDAO;
import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventTrackerController {

    @Autowired
    IEventService eventService;

    @Autowired
    IEventDAO eventDAO;
    /**
     * Handle the / endpoint
     * @return start.html
     */
    @RequestMapping("/")
    public String index(Model model) {
        Event event = new Event();
        event.setTitle("UC Hackathon");
        event.setLocation("Crosley tower");
        event.setStartTime("1pm");
        event.setEndTime("5pm");
        event.setDescription("Groups compete to solve problems");
        event.setHost("CECH");
        model.addAttribute(event);
        return "start";
    }


    @PostMapping(value = "/createEvent", consumes = "application/json", produces = "application/json")
    public Event createEvent(Event event) throws Exception {
        Event newEvent = null;
        eventDAO.save(event);
        return event;
    }

    @RequestMapping("/saveEvent")
    public String saveEvent(Event event) throws Exception {
        Event newEvent = null;
        try {
            newEvent = eventService.save(event);
        } catch (Exception e) {
            e.printStackTrace();
            return "createEvent";
        }
        return "createEvent";
    }



}