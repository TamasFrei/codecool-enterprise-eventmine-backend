package com.codecool.eventmine.eventmine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConcertTicket extends Ticket {

    @Enumerated(EnumType.STRING)
    private PlaceType placeType;

    @Builder
    public ConcertTicket(double price, String place, Event event, PlaceType placeType) {
        super(price, place, event);
        this.placeType = placeType;
    }
}
