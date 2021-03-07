package com.uceventtracker.eventtracker.dto;

import lombok.Data;

public @Data
class Event {
    private int eventID;
    private int hostID;
    private int dateID;
    private String title;
    private String location;
    private String date;
    private String startTime;
    private String endTime;
    private String description;
    private String hostName;
}
