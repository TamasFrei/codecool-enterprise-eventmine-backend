package com.codecool.eventmine.eventmine.controller;

import com.codecool.eventmine.eventmine.model.Concert;
import com.codecool.eventmine.eventmine.model.Event;
import com.codecool.eventmine.eventmine.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private ConcertRepository concertRepository;

    @GetMapping("/popularity")
    public List<Concert> listEventsByPopularity() {
        List<Concert> concerts = concertRepository.getConcertsByPopularity();
        for (Event concert : concerts) {
            concert.calculateAvailableTickets();
            concert.setAvailableTickets(null);
        }
        return concerts;
    }

    @GetMapping("/{keyword}")
    public List<Concert> listEventsByKeyword(@PathVariable("keyword") String keyword) {
        System.out.println("keyword: " + keyword);
        List<Concert> events = concertRepository.findConcertByKeyword(keyword);
        for (Event concert : events) {
            concert.calculateAvailableTickets();
            concert.setAvailableTickets(null);
        }
        return events;
    }

    @GetMapping("/{id}")
    public Concert getEventById(@PathVariable("id") Integer id) {
        Concert concert = concertRepository.findConcertById(id);
        concert.calculateAvailableTickets();
        concert.setAvailableTickets(null);
        return concert;
    }

}
