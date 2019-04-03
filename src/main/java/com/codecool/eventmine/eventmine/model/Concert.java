package com.codecool.eventmine.eventmine.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Concert extends Event {

    @ElementCollection
    @Singular
    private Set<String> performers;

    @Builder
    public Concert(String name, String location, LocalDate date, List<Ticket> availableTickets, Set<String> performers) {
        super(name, location, date, availableTickets);
        this.performers = performers;
    }
}
