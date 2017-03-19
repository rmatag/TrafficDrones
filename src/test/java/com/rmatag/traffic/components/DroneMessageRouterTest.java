package com.rmatag.traffic.components;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import com.rmatag.traffic.dto.DroneMessage;
import com.rmatag.traffic.dto.DroneMessageType;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

@RunWith(JUnitParamsRunner.class)
public class DroneMessageRouterTest {

    DroneMessageRouter router = new DroneMessageRouter();

    @Test
    @Parameters(method = "routeDroneMessagesParams")
    public void testRouteDroneMessage(DroneMessage message, String expectedQueue) {
        String queue = router.routeDroneMessage(message);
        assertThat(queue, is(expectedQueue));

    }

    private Object[] routeDroneMessagesParams() {
        DroneMessage drone5937Msg = new DroneMessage(DroneMessageType.MOVE, "5937", 0.0, 0.0, new Date());
        DroneMessage drone6043Msg = new DroneMessage(DroneMessageType.MOVE, "6043", 0.0, 0.0, new Date());
        return $(
                $(drone5937Msg, "queue5937"),
                $(drone6043Msg, "queue6043")
        );
    }


}
