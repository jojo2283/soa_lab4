package com.jellyone.oscars.dto;


import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Movie", propOrder = {
        "id", "name", "coordinates", "creationDate",
        "oscarsCount", "goldenPalmCount", "budget", "genre", "screenwriter"
})
public class MovieDto {

    private Long id;
    private String name;
    private CoordinatesDto coordinates;
    private String creationDate;
    private Integer oscarsCount;
    private Integer goldenPalmCount;
    private String budget; // BigDecimal как строка
    private String genre;  // MovieGenre.name()
    private PersonDto screenwriter;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CoordinatesDto getCoordinates() { return coordinates; }
    public void setCoordinates(CoordinatesDto coordinates) { this.coordinates = coordinates; }

    public String getCreationDate() { return creationDate; }
    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }

    public Integer getOscarsCount() { return oscarsCount; }
    public void setOscarsCount(Integer oscarsCount) { this.oscarsCount = oscarsCount; }

    public Integer getGoldenPalmCount() { return goldenPalmCount; }
    public void setGoldenPalmCount(Integer goldenPalmCount) { this.goldenPalmCount = goldenPalmCount; }

    public String getBudget() { return budget; }
    public void setBudget(String budget) { this.budget = budget; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public PersonDto getScreenwriter() { return screenwriter; }
    public void setScreenwriter(PersonDto screenwriter) { this.screenwriter = screenwriter; }
}