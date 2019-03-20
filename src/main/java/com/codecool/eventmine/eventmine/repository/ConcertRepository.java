package com.codecool.eventmine.eventmine.repository;

import com.codecool.eventmine.eventmine.model.Concert;
import com.codecool.eventmine.eventmine.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Integer> {

    @Query(value = "SELECT concert.id, date, location, name FROM concert inner join concert_ticket on concert.id=concert_ticket.event_id\n" +
            "GROUP BY concert.id, concert_ticket.event_id\n" +
            "ORDER BY count(concert_ticket.event_id) ASC", nativeQuery = true)
    List<Concert> getConcertsByPopularity();

}
