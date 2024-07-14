package dev.codex.cinestar.Movie.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter

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

    @ManyToMany(mappedBy = "movies",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Author> authors;
}
