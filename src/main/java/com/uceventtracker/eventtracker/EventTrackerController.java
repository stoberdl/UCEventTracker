package com.uceventtracker.eventtracker;

import com.uceventtracker.eventtracker.dto.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventTrackerController {
    /**
     * Handle the / endpoint
     * @return start.html
     */
    @RequestMapping("/")
    public String index(Model model) {
        Event event = new Event();
        event.setEventId(10);
        event.setTitle("UC Hackathon");
        event.setLocation("Crosley tower");
        event.setStartTime("1pm");
        event.setEndTime("5pm");
        event.setDescription("Groups compete to solve problems");
        event.setHost("CECH");
        model.addAttribute(event);
        return "start";
    }


}