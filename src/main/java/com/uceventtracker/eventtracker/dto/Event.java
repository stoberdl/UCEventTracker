package com.uceventtracker.eventtracker.dto;

import lombok.Data;

public @Data
class Event {
    private int eventId;
    private String title;
    private String location;
    private String startTime;
    private String endTime;
    private String description;
    private String host;
}
