package com.codecool.eventmine.eventmine.repository;

import com.codecool.eventmine.eventmine.model.Concert;
import com.codecool.eventmine.eventmine.model.ConcertTicket;
import com.codecool.eventmine.eventmine.model.PlaceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@ActiveProfiles("test")
public class ConcertRepositoryTests {

    @Autowired
    ConcertRepository concertRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void findConcertById() {
        Concert prodigy = Concert.builder()
                .name("Prodigy")
                .date(LocalDate.of(2019, 7, 20))
                .location("Budapest")
                .build();

        Concert hansZimmer = Concert.builder()
                .name("Hans Zimmer")
                .date(LocalDate.of(2019, 7, 20))
                .location("Budapest")
                .build();
        concertRepository.saveAll(Arrays.asList(prodigy, hansZimmer));

        Concert concert = concertRepository.findConcertById(2);
        assertThat(concert.getId()).isEqualTo(2);
    }

    @Test
    public void findEventsByKeyword() {
        Concert prodigy1 = Concert.builder()
                .name("Prodigy1")
                .date(LocalDate.of(2019, 7, 20))
                .location("Budapest")
                .build();

        Concert hansZimmer = Concert.builder()
                .name("Hans Zimmer")
                .date(LocalDate.of(2019, 7, 20))
                .location("Budapest")
                .build();

        Concert prodigy2 = Concert.builder()
                .name("Prodigy2")
                .date(LocalDate.of(2019, 7, 20))
                .location("Budapest")
                .build();
        concertRepository.saveAll(Arrays.asList(prodigy1, hansZimmer, prodigy2));

        List<Concert> concerts = concertRepository.findConcertByKeyword("Pro");
        assertThat(concerts).hasSize(2);
    }

    @Test
    public void listEventsOrderByPopularity() {
        Concert prodigy = Concert.builder()
                .name("Prodigy")
                .date(LocalDate.of(2019, 7, 20))
                .location("Budapest")
                .build();

        Concert hansZimmer = Concert.builder()
                .name("Hans Zimmer")
                .date(LocalDate.of(2019, 7, 20))
                .location("Budapest")
                .build();

        Concert pink = Concert.builder()
                .name("Pink")
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
                .event(hansZimmer)
                .build();

        prodigy.setAvailableTickets(Arrays.asList(ticket1, ticket2));
        hansZimmer.setAvailableTickets(Collections.singletonList(ticket3));
        concertRepository.saveAll(Arrays.asList(prodigy, hansZimmer, pink));

        List<Concert> concerts = concertRepository.getConcertsByPopularity();
        assertThat(concerts).containsSequence(hansZimmer, prodigy);
    }
}
