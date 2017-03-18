package com.rmatag.traffic.model;

import java.util.Date;

public class DroneMessage {

    private DroneMessageType type;

    private Double latitude;

    private Double longitude;

    private Date time;

    public DroneMessage() {
    }

    public DroneMessage(DroneMessageType type, Double latitude, Double longitude, Date time) {
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
    }

}
