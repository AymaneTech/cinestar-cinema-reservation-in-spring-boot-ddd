package dev.codex.cinestar.Movie.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

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

    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Author> authors;

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
