package com.codecool.eventmine.eventmine.repository;

import com.codecool.eventmine.eventmine.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.repository.query.Param;

public interface ConcertRepository extends JpaRepository<Concert, Integer> {

    @Query(value = "SELECT concert.id, date, location, name FROM concert inner join concert_ticket on concert.id=concert_ticket.event_id\n" +
            "GROUP BY concert.id, concert_ticket.event_id\n" +
            "ORDER BY count(concert_ticket.event_id) ASC", nativeQuery = true)
    List<Concert> getConcertsByPopularity();

    @Query("select s from Concert s where s.name like %:keyword%")
    List<Concert> findConcertByKeyword(@Param("keyword") String keyword);

    Concert findConcertById(Integer id);

}
