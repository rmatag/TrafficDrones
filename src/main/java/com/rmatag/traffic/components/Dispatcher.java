package com.rmatag.traffic.components;

import com.rmatag.traffic.TrafficDronesApp;
import com.rmatag.traffic.dto.DroneMessage;
import com.rmatag.traffic.dto.DroneMessageType;

import java.util.List;

public class Dispatcher implements Runnable {
    public static final String SIMULATION_TIMEOUT = "08:10:00";

    private MessageGateway messageGateway;

    private List<DroneMessage> droneMessages;

    public Dispatcher(MessageGateway messageGateway, List<DroneMessage> dronesMessages) {
        this.messageGateway = messageGateway;
        this.droneMessages = dronesMessages;
    }

    @Override
    public void run() {
        boolean shutdown = false;
        int i = 0;

        while (!shutdown && i < droneMessages.size()) {
            DroneMessage message = droneMessages.get(i);
            if (!DroneMessageType.SHUTDOWN.equals(message.getDroneMessageType())) {
                messageGateway.sendMessage(message);
                i++;
            } else {
                shutdown = true;
                TrafficDronesApp.shutdownTrafficDronesApp();
            }
        }
    }

    public void setDroneMessages(List<DroneMessage> droneMessages) {
        this.droneMessages = droneMessages;
    }
}
