package com.rmatag.traffic.components;

import com.rmatag.traffic.dto.Drone;
import com.rmatag.traffic.dto.TrafficConditionType;
import com.rmatag.traffic.dto.TrafficReport;
import com.rmatag.traffic.dto.TubeStation;
import com.rmatag.traffic.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by rmata on 3/18/17.
 */
public class ReportTrafficDAO {
    private static final Logger logger = LoggerFactory.getLogger(ReportTrafficDAO.class);

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
                .forEach(nearbyStation-> reportTrafficConditions(drone.getId(), nearbyStation.getName()));
    }

    private boolean isTubeStationInArea(TubeStation tubeStation, Drone drone) {
        int absDistance = (int) Math.sqrt(Math.pow(tubeStation.getLatitude() - drone.getLatitude(), 2) + Math.pow(
                tubeStation.getLongitude() - drone.getLongitude(), 2));

        return absDistance < MIN_DISTANCE_TO_STATION.intValue();
    }

    private void reportTrafficConditions(String droneId, String tubeStationName) {

        String time = Date.from(Instant.now()).toString();
        String droneSpeed = Drone.SPEED.toString();
        String trafficCondition = getRandomTrafficCondition();

        TrafficReport report = new TrafficReport(droneId, tubeStationName, time, droneSpeed, trafficCondition);
        logger.info("Reporting Traffic Condition of Tube Station {} by the drone {}", tubeStationName, droneId);

        FileUtils.storeTrafficConditionInFile(report);
    }

    private String getRandomTrafficCondition() {
        return TrafficConditionType.values()[new Random().nextInt(2)].name();
    }


}
