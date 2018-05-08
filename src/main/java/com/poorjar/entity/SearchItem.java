package com.poorjar.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @NoArgsConstructor
public final class SearchItem {
    @Id private long id;
    private String trackName;

    public SearchItem(long id, String trackName) {
        super();
        this.id = id;
        this.trackName = trackName;
    }
}
