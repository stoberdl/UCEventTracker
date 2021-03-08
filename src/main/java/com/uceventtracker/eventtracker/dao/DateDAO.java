package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Date;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DateDAO implements IDateDAO {

    private Map<Integer, Date> dates = new HashMap<>();

    @Override
    public boolean createEvent(Date date) {
        dates.put(date.getDateID(), date);
        if (dates.containsKey(date.getDateID())) return true;

        return false;
    }

    @Override
    public Date fetchByDate(String date) {
        List<Date> dateList = new ArrayList<>(dates.values());
        Date chooseDate = new Date();

        for (Date cDate : dateList) {
            if (cDate.getDate().equals(date)) {
                chooseDate = cDate;
            }
        }

        return chooseDate;
    }
}
