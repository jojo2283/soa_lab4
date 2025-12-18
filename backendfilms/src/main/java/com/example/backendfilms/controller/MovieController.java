package com.example.backendfilms.controller;



import com.example.backendfilms.exception.ApiException;
import com.example.backendfilms.model.Movie;
import com.example.backendfilms.model.MovieGenre;
import com.example.backendfilms.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Movie movie) {
        log.info("Creating movie - {}", movie.getName());
        try {
            Movie created = movieService.createMovie(movie);
            log.info("Movie created successfully with ID: {}", created.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (SQLException e) {
            log.error("Error creating movie", e);
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create movie");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        log.info("Getting movie by ID - {}", id);
        try {
            Movie movie = movieService.getMovieById(id);
            if (movie == null) {
                throw new ApiException(HttpStatus.NOT_FOUND, "Movie not found");
            }
            return ResponseEntity.ok(movie);
        } catch (SQLException e) {
            log.error("Error getting movie", e);
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to get movie");
        }
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) MovieGenre genre,
            @RequestParam(required = false) String sort,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size) {

        log.info("Getting movies with filters - name: {}, genre: {}, sort: {}, page: {}, size: {}",
                name, genre, sort, page, size);

        List<Movie> movies = movieService.getAll(name, genre, sort, page, size);
        return ResponseEntity.ok(movies);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(@PathVariable Long id, @RequestBody Movie partialMovie) {
        log.info("Patching movie with ID - {}", id);
        try {
            Movie updated = movieService.updateMovie(id, partialMovie);
            if (updated == null) {
                throw new ApiException(HttpStatus.NOT_FOUND, "Movie not found");
            }
            return ResponseEntity.ok(updated);
        } catch (SQLException e) {
            log.error("Error updating movie", e);
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update movie");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Movie movie) {
        log.info("Updating movie with ID - {} via PUT", id);
        try {
            Movie updated = movieService.updateMovie(id, movie);
            if (updated == null) {
                throw new ApiException(HttpStatus.NOT_FOUND, "Movie not found");
            }
            return ResponseEntity.ok(updated);
        } catch (SQLException e) {
            log.error("Error updating movie via PUT", e);
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update movie");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("Deleting movie with ID - {}", id);
        boolean deleted = movieService.deleteMovie(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        throw new ApiException(HttpStatus.NOT_FOUND, "Movie not found");
    }

    @DeleteMapping("/oscarsCount/{count}")
    public ResponseEntity<?> deleteByOscarsCount(@PathVariable int count) {
        log.info("Deleting movies with oscars count - {}", count);
        boolean anyDeleted = movieService.deleteMoviesByOscarsCount(count);
        if (anyDeleted) {
            return ResponseEntity.noContent().build();
        }
        throw new ApiException(HttpStatus.NOT_MODIFIED, "No movies matched deletion criteria");
    }

    @GetMapping("/count/oscars-less-than/{count}")
    public ResponseEntity<?> countMoviesWithOscarsLessThan(@PathVariable int count) {
        log.info("Counting movies with oscars less than - {}", count);
        try {
            long cnt = movieService.countMoviesWithOscarsLessThan(count);
            Map<String, Object> response = new HashMap<>();
            response.put("count", cnt);
            return ResponseEntity.ok(response);
        } catch (SQLException e) {
            log.error("Error counting movies", e);
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to count movies");
        }
    }

    @GetMapping("/name-starts-with/{prefix}")
    public ResponseEntity<?> getMoviesByNamePrefix(@PathVariable String prefix) {
        log.info("Getting movies with name prefix - {}", prefix);
        try {
            List<Movie> result = movieService.getMoviesByNamePrefix(prefix);
            return ResponseEntity.ok(result);
        } catch (SQLException e) {
            log.error("Error getting movies by prefix", e);
            throw new ApiException(HttpStatus.BAD_REQUEST, "Failed to get movies by prefix");
        }
    }
}