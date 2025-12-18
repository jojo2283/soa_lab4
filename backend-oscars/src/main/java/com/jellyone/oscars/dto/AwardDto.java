package com.jellyone.oscars.dto;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Award", propOrder = { "awardId", "date", "category" })
public class AwardDto {

    private int awardId;
    private String date;
    private String category;

    public int getAwardId() { return awardId; }
    public void setAwardId(int awardId) { this.awardId = awardId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}