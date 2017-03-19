package com.rmatag.traffic.utils;

import com.rmatag.traffic.components.Dispatcher;
import com.rmatag.traffic.dto.DroneMessage;
import com.rmatag.traffic.dto.DroneMessageType;
import com.rmatag.traffic.dto.TrafficReport;
import com.rmatag.traffic.dto.TubeStation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    private static final String COORDINATES_FILES_PATH = "classpath:coordinatesFiles/";

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private static String splitChar = ",";

    public static List<DroneMessage> getDroneMessageFromFile(String fileName) {
        List<String> fileLines;
        List<DroneMessage> droneMessages = new ArrayList<>();

        File file;
        try {
            file = ResourceUtils.getFile(COORDINATES_FILES_PATH + fileName);
            fileLines = Files.readAllLines(file.toPath());
            droneMessages = fileLines.stream().map(l -> convertLineToDroneMessage(l, splitChar)).collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return droneMessages;
    }

    public static List<TubeStation> getTubeStationFromFile(String fileName) {
        List<String> fileLines;
        List<TubeStation> tubeStationInfoList = new ArrayList<>();

        String splitChar = ",";

        File file;
        try {
            file = ResourceUtils.getFile(COORDINATES_FILES_PATH + fileName);
            fileLines = Files.readAllLines(file.toPath());
            tubeStationInfoList =
                    fileLines.stream().map(l -> convertLineToTubeStation(l, splitChar)).collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tubeStationInfoList;
    }

    private static String generateReportLine(TrafficReport trafficReport) {
        StringBuffer sb = new StringBuffer();
        sb.append(trafficReport.getTubeStationName());
        sb.append(splitChar);
        sb.append(trafficReport.getDroneId());
        sb.append(splitChar);
        sb.append(trafficReport.getTime());
        sb.append(splitChar);
        sb.append(trafficReport.getDroneSpeed());
        sb.append(splitChar);
        sb.append(trafficReport.getTrafficCondition());
        return sb.toString();
    }

    private static DroneMessage convertLineToDroneMessage(String line, String splitChar) {
        String[] splittedLine = line.split(splitChar);
        try {
            DroneMessageType messageType = getDroneMessageType(cleanString(splittedLine[3]));
            return new DroneMessage(messageType, cleanString(splittedLine[0]),
                    Double.valueOf(cleanString(splittedLine[1])), Double.valueOf(cleanString(splittedLine[2])),
                    DATE_FORMAT.parse(cleanString(splittedLine[3])));
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }

    private static TubeStation convertLineToTubeStation(String line, String splitChar) {
        String[] splittedLine = line.split(splitChar);
        return new TubeStation(cleanString(splittedLine[0]), Double.valueOf(cleanString(splittedLine[1])),
                Double.valueOf(cleanString(splittedLine[2])));

    }

    private static DroneMessageType getDroneMessageType(String moveDate) throws ParseException {
        DroneMessageType messageType;

        String[] moveTimeSplit = moveDate.split(" ")[1].split(":");
        LocalTime moveTime = LocalTime.of(Integer.valueOf(moveTimeSplit[0]),
                Integer.valueOf(moveTimeSplit[1]));

        String[] simulationTimeSplit = Dispatcher.SIMULATION_TIMEOUT.split(":");
        LocalTime simulationTimeout = LocalTime.of(Integer.valueOf(simulationTimeSplit[0]),
                Integer.valueOf(simulationTimeSplit[1]));

        if (moveTime.isAfter(simulationTimeout)) {
            messageType = DroneMessageType.SHUTDOWN;
        } else {
            messageType = DroneMessageType.MOVE;
        }
        return messageType;
    }

    private static String cleanString(String str) {
        str = str.replace("\"", "");
        return str;
    }
}

