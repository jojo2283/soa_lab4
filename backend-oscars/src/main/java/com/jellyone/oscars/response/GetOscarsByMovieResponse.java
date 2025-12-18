package com.jellyone.oscars.response;

import com.jellyone.oscars.dto.AwardDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getOscarsByMovieResponse", namespace = "http://jellyone.com/oscars")
public class GetOscarsByMovieResponse {

    @XmlElement(name = "award")
    private List<AwardDto> awards = new ArrayList<>();

    public java.util.List<AwardDto> getAwards() { return awards; }
    public void setAwards(java.util.List<AwardDto> awards) { this.awards = awards; }
}