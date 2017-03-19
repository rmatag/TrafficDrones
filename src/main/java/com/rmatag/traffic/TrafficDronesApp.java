package com.rmatag.traffic;

import com.rmatag.traffic.components.Dispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class TrafficDronesApp {
    private static final Logger logger = LoggerFactory.getLogger("stdoutLogger");
    private static final int MAX_THREADS = 5;

    private ExecutorService executor;

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

    public static void shutdownTrafficDronesApp() {
        logger.info("Shutting down TrafficDronesApp");
        SpringApplication.run(TrafficDronesApp.class).close();
    }

    private void start() {
        logger.info("StartingTrafficDronesApp");
        initExecutor();
        executor.execute(dispatcher5937);
        executor.execute(dispatcher6043);
        shutdownExecutor();
    }

    private void initExecutor() {
        logger.info("Initializing Executor Dispatcher");
        executor = Executors.newFixedThreadPool(MAX_THREADS);
    }

    private void shutdownExecutor() {
        logger.info("Shutting down Executor Dispatcher");
        executor.shutdown();
    }
}
