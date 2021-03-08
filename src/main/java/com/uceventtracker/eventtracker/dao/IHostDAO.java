package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Host;

import java.util.Map;

/**
 * Data Access Object Interface for Hosts
 * <p>
 *     Gives access to Host data
 * </p>
 */
public interface IHostDAO {

    boolean createEvent(Host hostName);

    Host fetchByHostID(int hostID);

    Host fetchByHostName(String hostName);

    Map<Integer, Host> fetchAll();
}
