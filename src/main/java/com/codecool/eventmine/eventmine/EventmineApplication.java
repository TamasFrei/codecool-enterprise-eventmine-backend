package com.codecool.eventmine.eventmine;

import com.codecool.eventmine.eventmine.model.*;
import com.codecool.eventmine.eventmine.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class EventmineApplication {

    @Autowired
    private ConcertRepository concertRepository;

    public static void main(String[] args) {
        SpringApplication.run(EventmineApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Concert prodigy = Concert.builder()
                    .name("Prodigy")
                    .date(LocalDate.of(2019, 7, 20))
                    .location("Budapest")
                    .build();

            ConcertTicket ticket1 = ConcertTicket.builder()
                    .price(10000)
                    .place("D12")
                    .placeType(PlaceType.STANDING)
                    .event(prodigy)
                    .build();

            ConcertTicket ticket2 = ConcertTicket.builder()
                    .price(10000)
                    .place("D12")
                    .placeType(PlaceType.STANDING)
                    .event(prodigy)
                    .build();

            ConcertTicket ticket3 = ConcertTicket.builder()
                    .price(10000)
                    .place("D12")
                    .placeType(PlaceType.STANDING)
                    .event(prodigy)
                    .build();

            prodigy.setAvailableTickets(Arrays.asList(ticket1, ticket2, ticket3));


            Concert hansZimmer = Concert.builder()
                    .name("Hans Zimmer")
                    .date(LocalDate.of(2019, 7, 20))
                    .location("Budapest")
                    .build();

            ConcertTicket ticket4 = ConcertTicket.builder()
                    .price(10000)
                    .place("B1/12/3")
                    .placeType(PlaceType.STANDING)
                    .event(hansZimmer)
                    .build();

            ConcertTicket ticket5 = ConcertTicket.builder()
                    .price(10000)
                    .place("B1/12/3")
                    .placeType(PlaceType.SITTING)
                    .event(hansZimmer)
                    .build();

            hansZimmer.setAvailableTickets(Arrays.asList(ticket4, ticket5));

            concertRepository.save(prodigy);
            concertRepository.save(hansZimmer);
        };
    }

}