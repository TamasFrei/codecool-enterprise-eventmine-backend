package com.codecool.eventmine.eventmine.model;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Concert extends Event {

    @ElementCollection
    @Singular
    private Set<String> performers;



}
