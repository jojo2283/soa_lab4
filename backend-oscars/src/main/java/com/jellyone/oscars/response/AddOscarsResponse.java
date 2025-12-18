package com.jellyone.oscars.response;

import com.jellyone.oscars.dto.MovieUpdateResponseDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "addOscarsResponse", namespace = "http://jellyone.com/oscars")
public class AddOscarsResponse {

    @XmlElement(name = "updateResult")
    private MovieUpdateResponseDto updateResult;

    public MovieUpdateResponseDto getUpdateResult() { return updateResult; }
    public void setUpdateResult(MovieUpdateResponseDto updateResult) { this.updateResult = updateResult; }
}
