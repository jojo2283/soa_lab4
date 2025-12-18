package com.jellyone.oscars.dto;



import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Coordinates", propOrder = { "x", "y" })
public class CoordinatesDto {

    private Integer x;
    private Double y;

    public Integer getX() { return x; }
    public void setX(Integer x) { this.x = x; }

    public Double getY() { return y; }
    public void setY(Double y) { this.y = y; }
}
