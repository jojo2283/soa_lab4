package com.jellyone.oscars.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "deleteOscarsByMovieRequest", namespace = "http://jellyone.com/oscars")
public class DeleteOscarsByMovieRequest {

    private long movieId;

    public long getMovieId() { return movieId; }
    public void setMovieId(long movieId) { this.movieId = movieId; }
}