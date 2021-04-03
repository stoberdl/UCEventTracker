package com.uceventtracker.eventtracker.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "EVENTS")
public @Data
class Event {

    @Id
    @Column(name = "title", nullable = false, unique = true, length = 512)
    private String title;

    @Column(name = "description", nullable = false, length = 512)
    private String description;

    @Column(name = "username", nullable = false, length = 512)
    private String location;

    @Column(name = "date", nullable = false, length = 45)
    private Date date;

    @Column(name = "startTime", nullable = false, length = 45)
    private String startTime;

    @Column(name = "endTime", nullable = false, length = 45)
    private String endTime;

    @Column(name = "host", nullable = false, length = 45)
    private String host;
}
