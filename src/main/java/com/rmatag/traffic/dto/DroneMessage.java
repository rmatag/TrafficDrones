package com.rmatag.traffic.dto;

import java.util.Date;

public class DroneMessage {

    private DroneMessageType type;

    private String droneId;

    private Double latitude;

    private Double longitude;

    private Date time;

    public DroneMessage() {
    }

    public DroneMessage(DroneMessageType type, String droneId, Double latitude, Double longitude, Date time) {
        this.type = type;
        this.droneId = droneId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
    }

    public String getDroneId() {
        return droneId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "DroneMessage{" +
                "type=" + type +
                ", droneId=" + droneId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", time=" + time +
                '}';
    }
}
