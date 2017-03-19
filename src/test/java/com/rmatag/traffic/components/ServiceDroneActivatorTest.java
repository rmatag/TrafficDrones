package com.rmatag.traffic.components;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import com.rmatag.traffic.dto.Drone;
import com.rmatag.traffic.dto.DroneMessage;
import com.rmatag.traffic.dto.DroneMessageType;
import org.junit.Test;

import java.util.Date;

public class ServiceDroneActivatorTest {

    ServiceDroneActivator droneActivator = new ServiceDroneActivator();

    Double newLatitude = 10.0;
    Double newLongitude = 30.0;

    @Test
    public void testMoveDrone5937() {
        givenDrone5937Initialized();
        DroneMessage message = givenAMessageReachsActivator(newLatitude, newLongitude);
        Drone drone5937 = whenActivatorMovesDrone5937(message);
        thenTheDroneHasBeenMovedToNewPosititon(newLatitude, newLongitude, drone5937);

    }

    @Test
    public void testMoveDrone6043() {
        givenDrone6043Initialized();
        DroneMessage message = givenAMessageReachsActivator(newLatitude, newLongitude);
        Drone drone6043 = whenActivatorMovesDrone6043(message);
        thenTheDroneHasBeenMovedToNewPosititon(newLatitude, newLongitude, drone6043);

    }

    private void thenTheDroneHasBeenMovedToNewPosititon(Double newLatitude, Double newLongitude, Drone drone) {
        assertThat("The Latitude of the drone was updated", newLatitude, is(drone.getLatitude()));
        assertThat("The Longitude of the drone was updated", newLongitude, is(drone.getLongitude()));
    }

    private Drone whenActivatorMovesDrone5937(DroneMessage message) {
        return droneActivator.moveDrone5937(message);
    }

    private Drone whenActivatorMovesDrone6043(DroneMessage message) {
        return droneActivator.moveDrone6043(message);
    }

    private void givenDrone5937Initialized() {
        Drone drone5937 = new Drone();
        droneActivator.setDrone5937(drone5937);
    }

    private void givenDrone6043Initialized() {
        Drone drone6043 = new Drone();
        droneActivator.setDrone6043(drone6043);
    }

    private DroneMessage givenAMessageReachsActivator(Double newLatitude, Double newLongitude) {
        return new DroneMessage(DroneMessageType.MOVE, "5937", newLatitude, newLongitude, new Date());
    }
}
