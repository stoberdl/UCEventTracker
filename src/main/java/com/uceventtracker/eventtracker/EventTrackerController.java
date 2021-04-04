package com.uceventtracker.eventtracker;

import com.uceventtracker.eventtracker.dto.Event;
import com.uceventtracker.eventtracker.service.EventService;
import com.uceventtracker.eventtracker.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EventTrackerController {

    @Autowired
    IEventService eventService;

    /**
     * Handle the / endpoint
     * @return start.html
     */
    @RequestMapping("/")
    public String index() {

        return "start";
    }

    /**
     * Handle the /createEvent endpoint
     * @param model populates create event fields
     * @return createEvent.html
     */
    @RequestMapping("/createEvent")
    public String createEvent(Model model) {
        Event event = new Event();
        event.setTitle("UC Hackathon");
        event.setDescription("Groups compete to solve problems");
        event.setLocation("Crosley tower");
        event.setStartTime("1pm");
        event.setEndTime("5pm");
        event.setHost("CECH");
        model.addAttribute(event);

        return "createEvent";
    }

    /**
     * Handle the /saveEvent endpoint
     * @param event object to save
     * @return createEvent.html so less clicking and user can go back to
     * making another event if needed
     */
    @RequestMapping("/saveEvent")
    public String saveEvent(Event event) {
        try {
            eventService.save(event);
        } catch (Exception e) {
            e.printStackTrace();

            return "createEvent";
        }

        return "createEvent";
    }

    /**
     * Create a new event object, given the data provided.
     *
     * returns one fo the status codes:
     * 201: successfully created new event
     * 409: unable to create an event because it already exists
     *
     * @param event a JSON representation of a specimen object
     * @return the newly created event
     */
    @PostMapping(value="/event", consumes="application/json", produces="application/json")
    @ResponseBody
    public Event createEvent(@RequestBody Event event) {
        Event newEvent = null;
        try {
            newEvent = eventService.save(event);
        } catch (Exception e) {
            // TODO add logging
        }

        return newEvent;
    }

    /**
     * Gets the searchTerm the user inputs in the URL
     * @param requestParams
     * @return a page where the status is OK
     */
    @GetMapping("/titles")
    public ResponseEntity searchTitles(@RequestParam Map<String, String> requestParams) {
        int params = requestParams.size();
        String searchValue = requestParams.get("searchTerm");

        return new ResponseEntity(HttpStatus.OK);
    }

}