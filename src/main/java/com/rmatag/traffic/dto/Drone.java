package com.rmatag.traffic.dto;

import java.util.Date;

public class Drone {
    public static final Double SPEED = 30.5;

    private String id;

    private Double latitude;

    private Double longitude;

    private Date time;

    public Drone() {
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    public Drone(String id) {
        this.id = id;
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void moveDrone(Double lat, Double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", time=" + time +
                '}';
    }
}
