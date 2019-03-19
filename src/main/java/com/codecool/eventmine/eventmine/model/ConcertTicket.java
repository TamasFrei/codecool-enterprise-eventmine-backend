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
@Builder
@Entity
public class ConcertTicket extends Ticket {

    @Enumerated(EnumType.STRING)
    private PlaceType placeType;


}
