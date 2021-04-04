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
     * Handle the / endpoint
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

//    @GetMapping("/titles")
//    public ResponseEntity searchTitles(@RequestParam(value="searchTerm", required=false, defaultValue="None") String searchTerm) {
//        String newSearchTerm = searchTerm + "";
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @GetMapping("/titles")
    public ResponseEntity searchTitles(@RequestParam Map<String, String> requestParams) {
        int params = requestParams.size();
        String searchValue = requestParams.get("searchTerm");
        return new ResponseEntity(HttpStatus.OK);
    }

}