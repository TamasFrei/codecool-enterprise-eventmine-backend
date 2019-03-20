package com.codecool.eventmine.eventmine.repository;

import com.codecool.eventmine.eventmine.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
    @Query("select s from Concert s where s.name like %:keyword%")
    List<Concert> findConcertByKeyword(@Param("keyword") String keyword);

    //List<Concert> findConcertByNameContaining(String keyword);
}
