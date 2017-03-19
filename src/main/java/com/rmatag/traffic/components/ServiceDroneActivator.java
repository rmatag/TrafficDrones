package com.rmatag.traffic.components;

import com.rmatag.traffic.dto.Drone;
import com.rmatag.traffic.dto.DroneMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceDroneActivator {
    private static final Logger logger = LoggerFactory.getLogger(ServiceDroneActivator.class);

    private Drone drone5937;
    private Drone drone6043;

    public Drone moveDrone5937(DroneMessage message) {
        logger.info("Moving the Drone 5937 to the point: Latitude: ({}, {}", message.getLatitude(), message.getLongitude());
        drone5937.setLatitude(message.getLatitude());
        drone5937.setLongitude(message.getLongitude());
        return drone5937;
    }

    public Drone moveDrone6043(DroneMessage message) {
        logger.info("Moving the Drone 6043 to the point: Latitude: ({}, {}", message.getLatitude(), message.getLongitude());
        drone6043.setLatitude(message.getLatitude());
        drone6043.setLongitude(message.getLongitude());
        return drone6043;
    }

    public void setDrone5937(Drone drone5937) {
        this.drone5937 = drone5937;
    }

    public void setDrone6043(Drone drone6043) {
        this.drone6043 = drone6043;
    }
}
