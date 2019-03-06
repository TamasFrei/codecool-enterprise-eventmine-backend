package com.codecool.eventmine.eventmine.model;

import java.util.Currency;

public class ConcertTicket extends Ticket {

    private PlaceType placeType;

    public ConcertTicket(double price, Currency currency, String place, PlaceType placeType) {
        super(price, currency, place);
        this.placeType = placeType;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }
}
