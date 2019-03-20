package com.codecool.eventmine.eventmine.controller;

import com.codecool.eventmine.eventmine.model.Concert;
import com.codecool.eventmine.eventmine.model.Event;
import com.codecool.eventmine.eventmine.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private ConcertRepository concertRepository;

    @GetMapping("/list/popularity")
    public List<Concert> getEventListByPopularity() {
        List<Concert> concerts = concertRepository.getConcertsByPopularity();
        for (Event concert : concerts) {
            concert.calculateAvailableTickets();
            concert.setAvailableTickets(null);
        }
        System.out.println(concerts);
        return concerts;
    }

    @GetMapping("/search/{keyword}")
    public List<Concert> searchEvents(@PathVariable("keyword") String keyword) {
        System.out.println("keyword: " + keyword);
        List<Concert> events = concertRepository.findConcertByKeyword(keyword);
        return events;
    }

}
