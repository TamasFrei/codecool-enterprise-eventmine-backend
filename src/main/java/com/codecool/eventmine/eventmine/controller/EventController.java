package com.codecool.eventmine.eventmine.controller;

import com.codecool.eventmine.eventmine.model.Concert;
import com.codecool.eventmine.eventmine.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private ConcertRepository concertRepository;

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Concert getEventById(@PathVariable("id") Integer id) {
        Concert concert = concertRepository.findConcertById(id);
        concert.calculateAvailableTickets();
        concert.setAvailableTickets(null);
        System.out.println(concert.getName());
        return concert;
    }
}
