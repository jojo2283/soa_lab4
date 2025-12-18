package com.jellyone.oscars.response;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "deleteOscarsByMovieResponse", namespace = "http://jellyone.com/oscars")
public class DeleteOscarsByMovieResponse {

    private boolean deleted;

    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }
}