package com.jellyone.oscars.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "honorMoviesByLengthRequest", namespace = "http://jellyone.com/oscars")
public class HonorMoviesByLengthRequest {

    private double minLength;
    private int oscarsToAdd;

    public double getMinLength() { return minLength; }
    public void setMinLength(double minLength) { this.minLength = minLength; }

    public int getOscarsToAdd() { return oscarsToAdd; }
    public void setOscarsToAdd(int oscarsToAdd) { this.oscarsToAdd = oscarsToAdd; }
}
