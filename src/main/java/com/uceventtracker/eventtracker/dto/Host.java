package com.uceventtracker.eventtracker.dto;

import lombok.Data;

public @Data
class Host {
    private int hostID;
    private int collegeID;
    private String location;
    private String hostName;
    private String college;

}
