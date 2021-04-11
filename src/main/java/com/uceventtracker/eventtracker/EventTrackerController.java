package com.uceventtracker.eventtracker;

import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.service.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @RequestMapping("/randomevent")
    public String randomevent(Model model) {
        allEvents = eventService.fetchEventsByCategory("Spirituality");
        model.addAttribute("events", allEvents);
        return "randomevent";
    }
    @RequestMapping("/about")
    public String index() {
        return "about";
    }

    @GetMapping("/events")
    public ResponseEntity searchEvents(@RequestParam(value = "searchTerm", required = false, defaultValue = "None")String searchTerm){
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/events")
    public ResponseEntity searchEvents(@RequestParam(value = "searchTerm", required = false, defaultValue = "None")String searchTerm){
        return new ResponseEntity(HttpStatus.OK);
    }
}