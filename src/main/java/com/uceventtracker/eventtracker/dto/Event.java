package com.uceventtracker.eventtracker.dto;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;


@Entity
@Table(name = "EVENTS")
public @Data
class Event {

    @Id
    @Column(name = "title", nullable = false, unique = true, length = 512)
    private String title;

    @Column(name = "description", nullable = false, length = 5000)
    private String description;

    @Column(name = "location", nullable = false, length = 512)
    private String location;

    @Column(name = "date", nullable = false, length = 45, columnDefinition = "date")
    private Date date;

    @Column(name = "startTime", nullable = false, length = 45)
    private String startTime;

    @Column(name = "endTime", nullable = false, length = 45)
    private String endTime;

    @Column(name = "host", nullable = false, length = 512)
    private String host;

    public String toString() {
        String[] dateArr = getDate().toString().split(" |,");

        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM")
                .withLocale(Locale.ENGLISH);
        TemporalAccessor accessor = parser.parse(dateArr[1]);
        String monthNum = Integer.toString(accessor.get(ChronoField.MONTH_OF_YEAR));

        String date = "" + dateArr[2] + "-" + monthNum + "-" + dateArr[5];

        try {
            setDate(new SimpleDateFormat("dd-MM-yyyy").parse(date));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return title + ": " + date;
    }
}
