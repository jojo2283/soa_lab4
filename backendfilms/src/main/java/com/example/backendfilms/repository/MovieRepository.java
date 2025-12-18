package com.example.backendfilms.repository;


import com.example.backendfilms.model.Movie;
import com.example.backendfilms.model.MovieGenre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    List<Movie> findByNameStartingWithIgnoreCase(String prefix);


    long deleteByOscarsCount(int count);


    long countByOscarsCountLessThan(int count);


    List<Movie> findByGenre(MovieGenre genre);




    @Query("SELECT m FROM Movie m " +
            "WHERE (LOWER(m.name) LIKE LOWER(CONCAT('%', :name, '%')) OR :name IS NULL) " +
            "AND (:genre IS NULL OR m.genre = :genre)")
    Page<Movie> findByFilters(@Param("name") String name,
                              @Param("genre") MovieGenre genre,
                              Pageable pageable);




}
