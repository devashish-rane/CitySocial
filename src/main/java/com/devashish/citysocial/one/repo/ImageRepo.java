package com.devashish.citysocial.one.repo;

import com.devashish.citysocial.one.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository< Image,Long> {
    Image findByName(String name);
}
