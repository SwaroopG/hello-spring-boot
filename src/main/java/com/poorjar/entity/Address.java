package com.poorjar.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor
public class Address implements Serializable {
    @Id @GeneratedValue private int id;
    @Column(name = "streetaddr1")
    private String streetAddr1;
    @Column(name = "streetaddr2")
    private String streetAddr2;
    private String city;
    private String state;
    private String country;
    private int zipcode;

    public Address(int id, String streetAddr1, String streetAddr2, String city,
                   String state, String country, int zipcode) {
        this.id = id;
        this.streetAddr1 = streetAddr1;
        this.streetAddr2 = streetAddr2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{id=" + id + ", streetAddr1=" + streetAddr1 + ", streetAddr2=" +
            streetAddr2 + ", city=" + city + ", state=" + state + ", country=" + country +
            ", zipcode=" + zipcode + '}';
    }
}
