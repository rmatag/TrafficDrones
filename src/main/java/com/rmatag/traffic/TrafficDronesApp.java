package com.rmatag.traffic;

import com.rmatag.traffic.components.Dispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TrafficDronesApp {

    @Autowired
    @Qualifier("dispatcher5937")
    Dispatcher dispatcher5937;

    @Autowired
    @Qualifier("dispatcher6043")
    Dispatcher dispatcher6043;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources(TrafficDronesApp.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);

        TrafficDronesApp app = context.getBean(TrafficDronesApp.class);
        app.start();
    }

    private void start() {
        dispatcher5937.sendMessages();
    }
}
