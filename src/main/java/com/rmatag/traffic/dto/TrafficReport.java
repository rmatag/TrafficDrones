package com.rmatag.traffic.dto;

/**
 * Created by rmata on 3/19/17.
 */
public class TrafficReport {

    private String droneId;
    private String tubeStationName;
    private String time;
    private String droneSpeed;
    private String trafficCondition;

    public TrafficReport() {}

    public TrafficReport(String droneId, String tubeStationName, String time, String droneSpeed, String trafficCondition) {
        this.droneId = droneId;
        this.tubeStationName = tubeStationName;
        this.time = time;
        this.droneSpeed = droneSpeed;
        this.trafficCondition = trafficCondition;
    }

    public String getDroneId() {
        return droneId;
    }

    public void setDroneId(String droneId) {
        this.droneId = droneId;
    }

    public String getTubeStationName() {
        return tubeStationName;
    }

    public void setTubeStationName(String tubeStationName) {
        this.tubeStationName = tubeStationName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDroneSpeed() {
        return droneSpeed;
    }

    public void setDroneSpeed(String droneSpeed) {
        this.droneSpeed = droneSpeed;
    }

    public String getTrafficCondition() {
        return trafficCondition;
    }

    public void setTrafficCondition(String trafficCondition) {
        this.trafficCondition = trafficCondition;
    }
}
