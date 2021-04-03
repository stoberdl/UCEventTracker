package com.uceventtracker.eventtracker;

import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
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
    public String index(Model model) {
        try {
            eventService.fetchRssEvents();
            List<Event> events = eventService.fetchAllEvents();
            model.addAttribute("events", events);
            return "start";
        } catch (Exception e) {
            e.printStackTrace();
            return "start";
        }

    }


}