package com.rmatag.traffic.config;

import com.rmatag.traffic.components.Dispatcher;
import com.rmatag.traffic.components.MessageGateway;
import com.rmatag.traffic.dto.Drone;
import com.rmatag.traffic.dto.DroneMessage;
import com.rmatag.traffic.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Configuration
@ComponentScan("com.rmatag.traffic")
@PropertySource("classpath:application.properties")
public class TrafficDronesAppConfig {

    @Value("${messages.file.5937}")
    private String messages5937File;

    @Value("${messages.file.6043}")
    private String messages6043File;

    @Bean
    public List<DroneMessage> messages5937() {

        return FileUtils.getDroneMessageFromFile(messages5937File);
    }

    @Bean
    public List<DroneMessage> messages6043() {

        return FileUtils.getDroneMessageFromFile(messages6043File);
    }

    @Bean
    public MessageGateway getMessageGateway() {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring_integration/spring-integration-config.xml");

        return (MessageGateway) context.getBean("messageGateway");
    }

    @Bean
    public Dispatcher dispatcher5937() {
        return new Dispatcher(getMessageGateway(), messages5937());
    }

    @Bean
    public Dispatcher dispatcher6043() {
        return new Dispatcher(getMessageGateway(), messages6043());
    }

    @Bean
    public Drone drone5937() {
        return new Drone("5937");
    }

    @Bean
    public Drone drone6043() {
        return new Drone("6043");
    }

}
