package com.codecool.eventmine.eventmine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Ticket {

    protected int id;
    protected double price;
    protected Currency currency;
    protected String place;

}
