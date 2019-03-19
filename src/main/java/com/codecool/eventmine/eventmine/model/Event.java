package com.codecool.eventmine.eventmine.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@MappedSuperclass
public abstract class Event {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    protected Long id;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String location;

    @Column(nullable = false)
    protected LocalDate date;

    @OneToMany(mappedBy = "ticket", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Singular
    protected List<Ticket> availableTickets;

}
