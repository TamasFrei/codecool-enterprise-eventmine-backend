package com.codecool.eventmine.eventmine.service;

import com.codecool.eventmine.eventmine.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventStorage {
    private List<Event> events = new ArrayList<>();

    @Autowired
    private EventCreator eventCreator;


    public Event addEvent(Event event) {
        events.add(event);
        return event;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void createRandomEvents(int numOfEvents){
        for (int i = 0; i < numOfEvents; i++) {
            addEvent(eventCreator.createRandomEvent());
        }

    }
}
