package com.uceventtracker.eventtracker.dao;

import com.uceventtracker.eventtracker.dto.Host;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HostDAO implements IHostDAO {

    private Map<Integer, Host> hosts = new HashMap<>();

    @Override
    public boolean createEvent(Host hostName) {
        hosts.put(hostName.getHostID(), hostName);
        if (hosts.containsKey(hostName.getHostID())) return true;

        return false;
    }

    @Override
    public Host fetchByHostID(int hostID) {
        List<Host> hostList = new ArrayList<>(hosts.values());
        Host chooseHost = new Host();

        for (Host cHost : hostList) {
            if (cHost.getHostID() == hostID) {
                chooseHost = cHost;
            }
        }

        return chooseHost;
    }

    @Override
    public Host fetchByHostName(String hostName) {
        List<Host> hostList = new ArrayList<>(hosts.values());
        Host chooseHost = new Host();

        for (Host cHost : hostList) {
            if (cHost.getHostName().equals(hostName)) {
                chooseHost = cHost;
            }
        }

        return chooseHost;
    }

    @Override
    public Map<Integer, Host> fetchAll() {
        return null;
    }
}
