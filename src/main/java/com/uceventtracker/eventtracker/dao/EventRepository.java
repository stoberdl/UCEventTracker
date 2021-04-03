package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Event;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface EventRepository extends CrudRepository<Event, String> {
}
