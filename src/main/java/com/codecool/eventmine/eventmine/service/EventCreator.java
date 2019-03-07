package com.codecool.eventmine.eventmine.service;

import com.codecool.eventmine.eventmine.model.Concert;
import com.codecool.eventmine.eventmine.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class EventCreator {

    private  List<String> eventNames = Arrays.asList("Pink","Rihanna","Ariana Grande","The Prodigy", "Shakira", "Jennifer Lopez");
    private  List<String> eventlocations = Arrays.asList("Sziget","VOLT", "EFOTT","Strand");
    private  Date eventDate = new Date();
    private Random random = new Random();



    public Event createRandomEvent(){
        String name = eventNames.get(random.nextInt(eventNames.size()));
        String eventLocation = eventlocations.get(random.nextInt(eventlocations.size()));
        int numOfRemainingTickets = random.nextInt(900) + 100;
        return new Concert(name, eventLocation, eventDate, numOfRemainingTickets, name);
    }



}
