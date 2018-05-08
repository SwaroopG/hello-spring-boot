package com.poorjar.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor
public class City implements Serializable {
    private static final long serialVersionUID = 5306730537093813023L;
    private String name;
    private String state;

    @Id @GeneratedValue private long id;

    public City(String name, String state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public String toString() {
        return "City{" + "name='" + name + '\'' + "state='" + state + '\'' + ", id=" + id + '}';
    }
}
