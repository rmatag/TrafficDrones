package com.rmatag.traffic.components;

import com.rmatag.traffic.dto.Drone;
import com.rmatag.traffic.dto.DroneMessage;

public class ServiceDroneActivator {

    Drone drone5937;
    Drone drone6043;

    public Drone moveDrone5937(DroneMessage message) {
        System.out.println("Moving the Drone 5937 to the point: Latitude: (" + message.getLatitude() + ", " + message.getLongitude() + ")");
        drone5937.setLatitude(message.getLatitude());
        drone5937.setLongitude(message.getLongitude());
        return drone5937;
    }

    public Drone moveDrone6043(DroneMessage message) {
        System.out.println("Moving the Drone 6043 to the point: Latitude: (" + message.getLatitude() + ", " + message.getLongitude() + ")");
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
