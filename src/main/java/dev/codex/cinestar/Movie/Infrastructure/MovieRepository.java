package dev.codex.cinestar.Movie.Infrastructure;

import dev.codex.cinestar.Movie.Domain.Entities.Category;
import dev.codex.cinestar.Movie.Domain.Entities.Movie;
import dev.codex.cinestar.Movie.Domain.ValueObjects.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitle(String title);

    List<Movie> findByCategory(Category category);

    List<Movie> findByType(MovieType type);

//    List<Movie> findByAuthor(Author author);
}