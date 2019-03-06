package com.codecool.eventmine.eventmine.service;

import com.codecool.eventmine.eventmine.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventStorage {
    private List<Event> events = new ArrayList<>();

    public Event addEvent(Event event) {
        events.add(event);
        return event;
    }
}
