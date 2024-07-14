package dev.codex.cinestar.Movie.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Movie> movies;
}
