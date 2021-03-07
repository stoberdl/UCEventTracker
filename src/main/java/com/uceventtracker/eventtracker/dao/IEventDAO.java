package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Event;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Map;

public interface IEventDAO {

    Map<Integer, Event> fetchAll();

    List<Event> fetchAllEvents();
}
