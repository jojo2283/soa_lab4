package com.example.backendfilms.service;


import com.example.backendfilms.exception.ApiException;
import com.example.backendfilms.model.Movie;
import com.example.backendfilms.model.MovieGenre;
import com.example.backendfilms.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie createMovie(Movie movie) throws SQLException {
        if (movie == null || movie.getName() == null || movie.getName().isBlank()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Movie name cannot be empty");
        }

        log.info("Saving new movie: {}", movie.getName());
        return movieRepository.save(movie);
    }


    public Movie getMovieById(Long id) throws SQLException {
        log.info("Fetching movie by ID: {}", id);
        return movieRepository.findById(id).orElse(null);
    }


    public List<Movie> getAll(String name, MovieGenre genre, String sort, int page, int size) {
        String sortBy = (sort != null && !sort.isEmpty()) ? sort : "id";
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sortBy).ascending());
        return movieRepository.findByFilters(name, genre, pageable).getContent();
    }


    public Movie updateMovie(Long id, Movie partialMovie) throws SQLException {
        log.info("Updating movie ID: {}", id);
        Movie existing = movieRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        if (partialMovie.getName() != null) existing.setName(partialMovie.getName());
        if (partialMovie.getCoordinates() != null) existing.setCoordinates(partialMovie.getCoordinates());
        if (partialMovie.getOscarsCount() != null) existing.setOscarsCount(partialMovie.getOscarsCount());
        if (partialMovie.getGoldenPalmCount() != null) existing.setGoldenPalmCount(partialMovie.getGoldenPalmCount());
        if (partialMovie.getBudget() != null) existing.setBudget(partialMovie.getBudget());
        if (partialMovie.getGenre() != null) existing.setGenre(partialMovie.getGenre());
        if (partialMovie.getScreenwriter() != null) existing.setScreenwriter(partialMovie.getScreenwriter());

        return movieRepository.save(existing);
    }


    public boolean deleteMovie(Long id) {
        log.info("Deleting movie ID: {}", id);
        if (!movieRepository.existsById(id)) {
            return false;
        }
        movieRepository.deleteById(id);
        return true;
    }


    public boolean deleteMoviesByOscarsCount(int count) {
        log.info("Deleting movies with oscarsCount = {}", count);
        long deleted = movieRepository.deleteByOscarsCount(count);
        return deleted > 0;
    }


    public long countMoviesWithOscarsLessThan(int count) throws SQLException {
        log.info("Counting movies with oscarsCount < {}", count);
        return movieRepository.countByOscarsCountLessThan(count);
    }


    public List<Movie> getMoviesByNamePrefix(String prefix) throws SQLException {
        log.info("Searching movies with name prefix '{}'", prefix);
        return movieRepository.findByNameStartingWithIgnoreCase(prefix);
    }
}