package com.codecool.eventmine.eventmine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Currency;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public abstract class Ticket {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    protected Long id;

    @Column(nullable = false)
    protected double price;

    @Column(nullable = false)
    protected Currency currency;
    protected String place;

    @ManyToOne
    protected Event event;
}
