package com.codecool.eventmine.eventmine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConcertTicket extends Ticket {

    private PlaceType placeType;

    public ConcertTicket(double price, Currency currency, String place, PlaceType placeType) {
        super(price, currency, place);
        this.placeType = placeType;
    }

}
