package com.rmatag.traffic.components;

import com.rmatag.traffic.dto.Drone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rmata on 3/18/17.
 */
public class ReportTrafficDAO {
    private static final Logger logger = LoggerFactory.getLogger(ReportTrafficDAO.class);

    public void reportTraffic(Drone drone) {
        logger.info("Reporting traffic from drone: {}", drone);
    }
}
