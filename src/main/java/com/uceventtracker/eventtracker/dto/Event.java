package com.uceventtracker.eventtracker.dto;

import lombok.Data;

import java.util.Date;

public @Data
class Event {
    private String title;
    private String description;
    private String location;
    private Date date;
    private String startTime;
    private String endTime;
    private String host;
}
