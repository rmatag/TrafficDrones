package com.rmatag.traffic.components;

import com.rmatag.traffic.model.DroneMessage;
import org.springframework.integration.annotation.Gateway;

public interface MessageGateway {

    @Gateway(requestChannel = "inputChannel")
    void sendMessage(DroneMessage message);
}
