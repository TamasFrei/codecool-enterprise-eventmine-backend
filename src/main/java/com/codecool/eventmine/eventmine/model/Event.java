package com.codecool.eventmine.eventmine.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Event {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    protected Integer id;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String location;

    @Column(nullable = false)
    protected LocalDate date;

    @OneToMany(mappedBy = "event", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Singular
    protected List<Ticket> availableTickets;

    @Transient
    protected int numOfAvailableTickets;

    public void calculateAvailableTickets() {
        this.numOfAvailableTickets = availableTickets.size();
    }

}
