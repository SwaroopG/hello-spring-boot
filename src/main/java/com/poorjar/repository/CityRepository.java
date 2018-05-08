package com.poorjar.repository;

import com.poorjar.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CityRepository extends JpaRepository<City, Long> {
    Collection<City> findCityByName(@Param("city") String name);
}
