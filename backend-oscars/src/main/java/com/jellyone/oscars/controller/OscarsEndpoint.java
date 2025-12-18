package com.jellyone.oscars.controller;

import com.jellyone.oscars.dto.*;
import com.jellyone.oscars.model.Award;
import com.jellyone.oscars.model.Movie;
import com.jellyone.oscars.model.MovieUpdateResponse;
import com.jellyone.oscars.model.Person;
import com.jellyone.oscars.request.*;
import com.jellyone.oscars.response.*;
import com.jellyone.oscars.service.OscarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
@RequiredArgsConstructor
public class OscarsEndpoint {

    private static final String NAMESPACE_URI = "http://jellyone.com/oscars";

    private final OscarsService service;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOscarLosersRequest")
    @ResponsePayload
    public GetOscarLosersResponse getOscarLosers(@RequestPayload GetOscarLosersRequest request) {
        List<Person> losers = service.getOscarLosers();

        GetOscarLosersResponse response = new GetOscarLosersResponse();
        response.setPersons(
                losers.stream()
                        .map(this::toPersonDto)
                        .collect(Collectors.toList())
        );
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "honorMoviesByLengthRequest")
    @ResponsePayload
    public HonorMoviesByLengthResponse honorMoviesByLength(@RequestPayload HonorMoviesByLengthRequest request) {
        MovieUpdateResponse result =
                service.honorMoviesByLength(request.getMinLength(), request.getOscarsToAdd(), null); // callback убираем

        HonorMoviesByLengthResponse response = new HonorMoviesByLengthResponse();
        response.setUpdateResult(toMovieUpdateResponseDto(result));
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "honorMoviesWithFewOscarsRequest")
    @ResponsePayload
    public HonorMoviesWithFewOscarsResponse honorMoviesWithFewOscars(
            @RequestPayload HonorMoviesWithFewOscarsRequest request
    ) {
        MovieUpdateResponse result =
                service.honorMoviesWithFewOscars(request.getMaxOscars(), request.getOscarsToAdd(), null);

        HonorMoviesWithFewOscarsResponse response = new HonorMoviesWithFewOscarsResponse();
        response.setUpdateResult(toMovieUpdateResponseDto(result));
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOscarsByMovieRequest")
    @ResponsePayload
    public GetOscarsByMovieResponse getOscarsByMovie(@RequestPayload GetOscarsByMovieRequest request) {
        List<Award> oscars = service.getOscarsByMovie(
                request.getMovieId(),
                request.getPage(),
                request.getSize()
        );

        GetOscarsByMovieResponse response = new GetOscarsByMovieResponse();
        response.setAwards(
                oscars.stream()
                        .map(this::toAwardDto)
                        .collect(Collectors.toList())
        );
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addOscarsRequest")
    @ResponsePayload
    public AddOscarsResponse addOscars(@RequestPayload AddOscarsRequest request) {
        MovieUpdateResponse result =
                service.addOscars(request.getMovieId(), request.getOscarsToAdd(), null);

        AddOscarsResponse response = new AddOscarsResponse();
        response.setUpdateResult(toMovieUpdateResponseDto(result));
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteOscarsByMovieRequest")
    @ResponsePayload
    public DeleteOscarsByMovieResponse deleteOscarsByMovie(
            @RequestPayload DeleteOscarsByMovieRequest request
    ) {
        boolean deleted = service.deleteOscarsByMovie(request.getMovieId());
        DeleteOscarsByMovieResponse response = new DeleteOscarsByMovieResponse();
        response.setDeleted(deleted);
        return response;
    }



    private PersonDto toPersonDto(Person p) {
        PersonDto dto = new PersonDto();
        dto.setName(p.name());
        dto.setBirthday(p.birthday() != null ? p.birthday().toString() : null);
        dto.setHeight(p.height());
        dto.setWeight(p.weight());
        dto.setPassportID(p.passportID());
        return dto;
    }

    private AwardDto toAwardDto(Award a) {
        AwardDto dto = new AwardDto();
        dto.setAwardId(a.awardId());
        dto.setDate(a.date());
        dto.setCategory(a.category());
        return dto;
    }

    private MovieDto toMovieDto(Movie m) {
        if (m == null) return null;

        MovieDto dto = new MovieDto();
        dto.setId(m.id());
        dto.setName(m.name());
        dto.setCreationDate(m.creationDate() != null ? m.creationDate().toString() : null);
        dto.setOscarsCount(m.oscarsCount());
        dto.setGoldenPalmCount(m.goldenPalmCount());
        dto.setBudget(m.budget() != null ? m.budget().toPlainString() : null);
        dto.setGenre(m.genre() != null ? m.genre().name() : null);
        dto.setCoordinates(toCoordinatesDto(m.coordinates()));
        dto.setScreenwriter(m.screenwriter() != null ? toPersonDto(m.screenwriter()) : null);
        return dto;
    }

    private CoordinatesDto toCoordinatesDto(com.jellyone.oscars.model.Coordinates c) {
        if (c == null) return null;
        CoordinatesDto dto = new CoordinatesDto();
        dto.setX(c.x());
        dto.setY(c.y());
        return dto;
    }

    private MovieUpdateResponseDto toMovieUpdateResponseDto(MovieUpdateResponse response) {
        MovieUpdateResponseDto dto = new MovieUpdateResponseDto();
        dto.setUpdatedCount(response.updatedCount());
        dto.setUpdatedMovies(
                response.updatedMovies()
                        .stream()
                        .map(this::toMovieDto)
                        .collect(Collectors.toList())
        );
        return dto;
    }
}