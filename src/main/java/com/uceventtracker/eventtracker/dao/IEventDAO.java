package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Event;
import java.util.List;

public interface IEventDAO {
    List<Event> fetchAllEvents();
}
