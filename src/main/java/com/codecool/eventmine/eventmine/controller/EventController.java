package com.codecool.eventmine.eventmine.controller;

import com.codecool.eventmine.eventmine.model.Concert;
import com.codecool.eventmine.eventmine.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private ConcertRepository concertRepository;

    @GetMapping("/{id}")
    public Concert getEventById(@PathVariable("id") Integer id) {
        Concert concert = concertRepository.findConcertById(id);
        concert.calculateAvailableTickets();
        concert.setAvailableTickets(null);
        return concert;
    }
}
