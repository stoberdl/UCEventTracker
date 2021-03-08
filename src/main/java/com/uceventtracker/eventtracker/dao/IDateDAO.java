package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Date;

/**
 * Data Access Object Interface for Dates
 * <p>
 *     Gives access to Date data
 * </p>
 */
public interface IDateDAO {

    boolean createEvent(Date date);

    Date fetchByDate(String date);
}
