package com.jellyone.oscars.dto;



import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MovieUpdateResponse", propOrder = { "updatedCount", "updatedMovies" })
public class MovieUpdateResponseDto {

    private Integer updatedCount;

    @XmlElement(name = "movie")
    private List<MovieDto> updatedMovies = new ArrayList<>();

    public Integer getUpdatedCount() { return updatedCount; }
    public void setUpdatedCount(Integer updatedCount) { this.updatedCount = updatedCount; }

    public List<MovieDto> getUpdatedMovies() { return updatedMovies; }
    public void setUpdatedMovies(List<MovieDto> updatedMovies) { this.updatedMovies = updatedMovies; }
}
