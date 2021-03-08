package com.uceventtracker.eventtracker.dto;

import lombok.Data;

public @Data
class Event {
    private int eventID;
    private int dataID;
    private int hostID;
    private String title;
    private String location;
    private String date;
    private String startTime;
    private String endTime;
    private String description;
    private String hostName;
}
