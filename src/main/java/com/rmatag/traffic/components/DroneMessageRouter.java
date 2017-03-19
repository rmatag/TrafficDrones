package com.rmatag.traffic.components;

import com.rmatag.traffic.dto.DroneMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rmata on 3/18/17.
 */
public class DroneMessageRouter {
    private static final Logger logger = LoggerFactory.getLogger(DroneMessageRouter.class);

    private static final String DRONE_5937_ID = "5937";
    private static final String DRONE_6043_ID = "6043";

    private static final String DRONE_5937_QUEUE = "queue5937";
    private static final String DRONE_6043_QUEUE = "queue6043";

    public String routeDroneMessage (DroneMessage message) {
        if (DRONE_5937_ID.equals(message.getDroneId())) {
            logger.info("Routing the log through queue: {}, ", DRONE_5937_QUEUE);
            return DRONE_5937_QUEUE;
        } else if (DRONE_6043_ID.equals(message.getDroneId())) {
            logger.info("Routing the log through queue: {}, ", DRONE_6043_QUEUE);
            return DRONE_6043_QUEUE;
        } else {
            throw new IllegalStateException("Router cannot recognized the Drone id");
        }
    }
}
