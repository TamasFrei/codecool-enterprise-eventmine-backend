package com.codecool.eventmine.eventmine;

import com.codecool.eventmine.eventmine.service.EventCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventmineApplication {
    @Autowired
    private EventCreator eventCreator;


    public static void main(String[] args) {
        SpringApplication.run(EventmineApplication.class, args);
    }

}