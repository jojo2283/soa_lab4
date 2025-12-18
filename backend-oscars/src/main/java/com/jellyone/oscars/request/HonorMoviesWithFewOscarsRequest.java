package com.jellyone.oscars.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "honorMoviesWithFewOscarsRequest", namespace = "http://jellyone.com/oscars")
public class HonorMoviesWithFewOscarsRequest {

    private int maxOscars;
    private int oscarsToAdd;

    public int getMaxOscars() { return maxOscars; }
    public void setMaxOscars(int maxOscars) { this.maxOscars = maxOscars; }

    public int getOscarsToAdd() { return oscarsToAdd; }
    public void setOscarsToAdd(int oscarsToAdd) { this.oscarsToAdd = oscarsToAdd; }
}