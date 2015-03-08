package com.poorjar.entity;

public final class SearchItem
{
    private long id;
    private String trackName;

    /**
     * @param id
     * @param trackName
     */
    public SearchItem(long id, String trackName)
    {
        super();
        this.id = id;
        this.trackName = trackName;
    }

    /**
     * @return the id
     */
    public final long getId()
    {
        return id;
    }

    /**
     * @return the track name
     */
    public final String getTrackName()
    {
        return trackName;
    }
}
