package com.codecool.eventmine.eventmine.controller;

import com.codecool.eventmine.eventmine.model.Event;
import com.codecool.eventmine.eventmine.service.EventStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class EventController {

    private EventStorage eventStorage;

    @Autowired
    public void setEventStorage(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @GetMapping("/list")
    public List<Event> eventList(){
        return eventStorage.getEvents();
    }

//    @GetMapping("/list/popularity")
//    public List<Event> eventListByPopularity(){
//        return eventStorage.getEvents().stream().sorted(Comparator.comparing(Event::getNumOfRemainingTickets)).collect(Collectors.toList());
//    }

//    @GetMapping("/random")
//    public void createRandomEvents(){
//        eventStorage.createRandomEvents(10);
//    }

    @GetMapping("/search/{keyword}")
    public List<Event> searchEvents(@PathVariable("keyword") String keyword) {
        System.out.println("keyword: " + keyword);
        List<Event> events = eventStorage.selectSearchedEvents(keyword);
        System.out.println(events.size());
        return events;
    }

}
