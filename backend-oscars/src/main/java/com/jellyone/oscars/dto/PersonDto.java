package com.jellyone.oscars.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person", propOrder = { "name", "birthday", "height", "weight", "passportID" })
public class PersonDto {

    @XmlElement(required = true)
    private String name;

    private String birthday;   // String вместо LocalDate (проще для JAXB)
    private Double height;
    private Integer weight;
    private String passportID;

    // getters / setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Integer getWeight() { return weight; }
    public void setWeight(Integer weight) { this.weight = weight; }

    public String getPassportID() { return passportID; }
    public void setPassportID(String passportID) { this.passportID = passportID; }
}