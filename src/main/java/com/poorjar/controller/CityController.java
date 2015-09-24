package com.poorjar.controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class CityController
{
    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("/cities")
    public List<City> handleRequest()
    {
        return this.cityRepository.findAll();
    }
}

@Entity
class City implements Serializable
{
    private static final long serialVersionUID = 5306730537093813023L;
    private String name;
    private String state;

    @Id
    @GeneratedValue
    private long id;

    City()
    {
    }

    public City(String name, String state)
    {
        this.name = name;
        this.state = state;
    }

    public String getName()
    {
        return name;
    }

    public String getState()
    {
        return state;
    }

    public long getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "City{" + "name='" + name + '\'' + "state='" + state + '\'' + ", id=" + id + '}';
    }
}

interface CityRepository extends JpaRepository<City, Long>
{
    Collection<City> findCityByName(@Param("city") String name);
}
