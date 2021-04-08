package com.uceventtracker.eventtracker;

import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.service.IEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EventTrackerController {
    List<Event> allEvents = new ArrayList<>();
    private final IEventService eventService;

    public EventTrackerController(IEventService eventService) {
        this.eventService = eventService;
    }

    /**
     * Handle the / endpoint
     * @return start.html
     */
    @RequestMapping("/")
    public String index(Model model) {
        allEvents = eventService.fetchAllEvents();
        model.addAttribute("events", allEvents);
        return "start";
    }
}