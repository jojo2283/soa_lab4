package com.jellyone.oscars.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "addOscarsRequest", namespace = "http://jellyone.com/oscars")
public class AddOscarsRequest {

    private long movieId;
    private int oscarsToAdd;

    public long getMovieId() { return movieId; }
    public void setMovieId(long movieId) { this.movieId = movieId; }

    public int getOscarsToAdd() { return oscarsToAdd; }
    public void setOscarsToAdd(int oscarsToAdd) { this.oscarsToAdd = oscarsToAdd; }
}
