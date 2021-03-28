package com.uceventtracker.eventtracker.dto;

import lombok.Data;

public @Data
class Event {
    private String title;
    private String description;
    private String location;
    private String startTime;
    private String endTime;
    private String host;
}
