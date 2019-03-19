package com.codecool.eventmine.eventmine;

import com.codecool.eventmine.eventmine.config.ControllerConfig;
import com.codecool.eventmine.eventmine.service.EventCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class EventmineApplication {

    @Autowired
    private EventCreator eventCreator;

    @Autowired
    private ControllerConfig controllerConfig;


    public static void main(String[] args) {
        SpringApplication.run(EventmineApplication.class, args);
    }

}