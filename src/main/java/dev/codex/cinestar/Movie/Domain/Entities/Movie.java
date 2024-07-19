package dev.codex.cinestar.Movie.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.codex.cinestar.Movie.Domain.ValueObjects.MovieType;
import dev.codex.cinestar.Schedule.Domain.Entities.Schedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String title;

    private String description;

    private String director;

    @Column(name = "release_year")
    private Date releaseYear;

    private String duration;

    private String language;

    private String country;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER)
    private List<Author> authors;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Schedule> schedules;

    public Movie(String title, String description, String director, String language, Date releaseYear, String duration, MovieType type, Category category, List<Author> authors, String country) {
        this.title = title;
        this.description = description;
        this.director = director;
        this.language = language;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.type = type;
        this.category = category;
        this.authors = authors;
        this.country = country;
    }
}
