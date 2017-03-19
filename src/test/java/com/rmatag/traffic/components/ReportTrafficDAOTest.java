package com.rmatag.traffic.components;

import com.rmatag.traffic.dto.Drone;
import com.rmatag.traffic.dto.TubeStation;
import com.rmatag.traffic.utils.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FileUtils.class)
public class ReportTrafficDAOTest {

    ReportTrafficDAO reportTrafficDAO = new ReportTrafficDAO();


    @Test
    public void testReportTrafficInsideArea() {
        Drone drone = givenTheDrone(349.0, 0.0);
        List<TubeStation> tubeStationsInfo = getTubeStations();
        givenFileUtilsMocked(tubeStationsInfo);

        reportTrafficDAO.reportTraffic(drone);
    }

    @Test
    public void testReportTrafficOutsideArea() {
        Drone drone = givenTheDrone(350.0, 0.0);
        List<TubeStation> tubeStationsInfo = getTubeStations();
        givenFileUtilsMocked(tubeStationsInfo);

        reportTrafficDAO.reportTraffic(drone);
    }

    private void givenFileUtilsMocked(List<TubeStation> tubeStationsInfo) {
        PowerMockito.mockStatic(FileUtils.class);
        PowerMockito.when(FileUtils.getTubeStationFromFile(any())).thenReturn(tubeStationsInfo);
    }

    private List<TubeStation> getTubeStations() {
        return new ArrayList<TubeStation>() {{ add(new TubeStation("stationName", 0.0, 0.0));}};
    }

    private Drone givenTheDrone(Double latitude, Double longitude) {
        Drone drone = new Drone();
        drone.setLatitude(latitude);
        drone.setLongitude(longitude);
        drone.setTime(new Date());
        return drone;
    }
}
