package com.rmatag.traffic.components;

import com.rmatag.traffic.dto.Drone;
import com.rmatag.traffic.dto.TrafficConditionType;
import com.rmatag.traffic.dto.TrafficReport;
import com.rmatag.traffic.dto.TubeStation;
import com.rmatag.traffic.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by rmata on 3/18/17.
 */
public class ReportTrafficDAO {
    private Logger logger = LoggerFactory.getLogger(ReportTrafficDAO.class);

    private static final Integer MIN_DISTANCE_TO_STATION = 350;

    private String tubeStationsInfoFile;

    public void setTubeStationsInfoFile(String tubeStationsInfoFile) {
        this.tubeStationsInfoFile = tubeStationsInfoFile;
    }

    public void reportTraffic(Drone drone) {
        List<TubeStation> tubeStationsInfo = FileUtils.getTubeStationFromFile(tubeStationsInfoFile);

        List<TubeStation> nearbyStations = tubeStationsInfo.stream()
                .filter(tubeStation -> isTubeStationInArea(tubeStation, drone))
                .collect(Collectors.toList());

        nearbyStations.stream()
                .forEach(nearbyStation-> reportTrafficConditions(drone, nearbyStation.getName()));
    }

    protected void reportTrafficConditions(Drone drone, String tubeStationName) {

        String droneId = drone.getId();
        String time = drone.getTime().toString();
        String droneSpeed = Drone.SPEED.toString();
        String trafficCondition = getRandomTrafficCondition();

        TrafficReport report = new TrafficReport(droneId, tubeStationName, time, droneSpeed, trafficCondition);
        logger.info("Insert into DB report: {}", report);
    }

    private boolean isTubeStationInArea(TubeStation tubeStation, Drone drone) {
        int absDistance = (int) Math.sqrt(Math.pow(tubeStation.getLatitude() - drone.getLatitude(), 2) + Math.pow(
                tubeStation.getLongitude() - drone.getLongitude(), 2));

        return absDistance < MIN_DISTANCE_TO_STATION.intValue();
    }

    private String getRandomTrafficCondition() {

        return TrafficConditionType.values()[new Random().nextInt(2)].name();
    }

    // A bt weird but in this case because there is not a DB connection we check the report is logged
    protected Logger getLogger() {
        return logger;
    }

}
