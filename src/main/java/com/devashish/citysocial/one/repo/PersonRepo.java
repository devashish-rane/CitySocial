package com.devashish.citysocial.one.repo;

import com.devashish.citysocial.one.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

}
