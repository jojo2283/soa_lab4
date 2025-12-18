package com.example.backendfilms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name", columnDefinition = "text")
    private String name;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinates_id")
    private Coordinates coordinates;

    private final LocalDate creationDate = LocalDate.now();

    @PositiveOrZero
    private Long oscarsCount;

    @PositiveOrZero
    private Long goldenPalmCount;

    @NotNull
    @Positive
    private Float budget;

    @Enumerated(EnumType.STRING)
    private MovieGenre genre;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "screenwriter_id")
    private Person screenwriter;
}