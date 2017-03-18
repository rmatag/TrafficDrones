package com.rmatag.traffic.components;

import com.rmatag.traffic.dto.DroneMessage;

import java.util.List;

public class Dispatcher {
    public static final String SIMULATION_TIMEOUT = "08:10:00";

    private MessageGateway messageGateway;

    private List<DroneMessage> droneMessages;

    public Dispatcher() {
    }

    public Dispatcher(MessageGateway messageGateway, List<DroneMessage> dronesMessages) {
        this.messageGateway = messageGateway;
        this.droneMessages = dronesMessages;
    }

    public void sendMessages() {

        messageGateway.sendMessage(this.droneMessages.get(0));
    }

}
