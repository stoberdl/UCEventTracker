package com.uceventtracker.eventtracker.dto;

import lombok.Data;

public @Data
class Event {
    private int eventId;
    private String eventTitle;
    private String eventLocation;
    private String startTime;
    private String endTime;
    private String eventDescription;
    private String eventHost;
}
