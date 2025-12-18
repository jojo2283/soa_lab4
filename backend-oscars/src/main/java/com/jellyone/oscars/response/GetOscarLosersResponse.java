package com.jellyone.oscars.response;

import com.jellyone.oscars.dto.PersonDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getOscarLosersResponse", namespace = "http://jellyone.com/oscars")
public class GetOscarLosersResponse {

    @XmlElement(name = "person")
    private List<PersonDto> persons = new ArrayList<>();

    public List<PersonDto> getPersons() { return persons; }
    public void setPersons(List<PersonDto> persons) { this.persons = persons; }
}