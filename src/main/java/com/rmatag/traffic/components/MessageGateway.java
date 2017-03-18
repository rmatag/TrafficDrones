package com.rmatag.traffic.components;

import com.rmatag.traffic.dto.DroneMessage;
import org.springframework.integration.annotation.Gateway;

public interface MessageGateway {

    @Gateway(requestChannel = "inputChannel")
    void sendMessage(DroneMessage message);
}
