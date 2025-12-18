package com.jellyone.oscars.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getOscarsByMovieRequest", namespace = "http://jellyone.com/oscars")
public class GetOscarsByMovieRequest {

    private long movieId;
    private int page = 1;
    private int size = 20;

    public long getMovieId() { return movieId; }
    public void setMovieId(long movieId) { this.movieId = movieId; }

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
}
