package com.rmatag.traffic.components;

import com.rmatag.traffic.dto.DroneMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
public class DispatcherTest {

    @Mock
    MessageGateway messageGateway;

    @InjectMocks
    Dispatcher dispatcher;

    @Test
    public void testRun() {
        givenDroneMessagesToBeSent();
        whenTheDispatcherIsRun();
        thenTheGatewaySendsMessage();
    }

    private void givenDroneMessagesToBeSent() {
        List<DroneMessage> messages = Collections.singletonList(new DroneMessage());
        dispatcher.setDroneMessages(messages);
    }

    private void whenTheDispatcherIsRun() {
        dispatcher.run();
    }

    private void thenTheGatewaySendsMessage() {
        verify(messageGateway).sendMessage(any());
    }

}
