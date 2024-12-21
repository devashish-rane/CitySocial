package com.devashish.citysocial.one.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;

    @OneToMany
    Set<Image> images;

    @ManyToMany
    Set<Person> visitedByPerson;
}
