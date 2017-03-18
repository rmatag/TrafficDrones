package com.rmatag.traffic.components;

import com.rmatag.traffic.dto.DroneMessage;

/**
 * Created by rmata on 3/18/17.
 */
public class DroneMessageRouter {

    private static final String DRONE_5937_ID = "5937";
    private static final String DRONE_6043_ID = "6043";

    private static final String DRONE_5937_QUEUE = "queue5937";
    private static final String DRONE_6043_QUEUE = "queue6043";

    public String routeDroneMessage (DroneMessage message) {
        System.out.println(message);
        if (DRONE_5937_ID.equals(message.getDroneId())) {
            return DRONE_5937_QUEUE;
        } else if (DRONE_6043_ID.equals(message.getDroneId())) {
            return DRONE_6043_QUEUE;
        } else {
            throw new IllegalStateException("Router cannot recognized the Drone id");
        }
    }
}
