package com.devashish.citysocial.one.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @EqualsAndHashCode.Exclude
    String email;
    @EqualsAndHashCode.Exclude
    String username;
    transient String password;

    @ManyToMany
    Set<Interest> hasInterest;

}