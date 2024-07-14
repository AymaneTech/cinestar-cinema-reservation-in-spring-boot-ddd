package dev.codex.cinestar.Movie.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Movie movie;
}
