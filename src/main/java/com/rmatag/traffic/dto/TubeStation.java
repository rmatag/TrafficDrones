package com.rmatag.traffic.dto;

/**
 * Created by rmata on 3/19/17.
 */
public class TubeStation {

    private String name;
    private Double latitude;
    private Double longitude;

    public TubeStation(){}

    public TubeStation(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
