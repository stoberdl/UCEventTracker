package com.uceventtracker.eventtracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventTrackerController {
    /**
     * Handle the / endpoint
     * @return start.html
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }


}