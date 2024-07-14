package dev.codex.cinestar.Movie.Infrastructure;

import dev.codex.cinestar.Movie.Domain.Author;
import dev.codex.cinestar.Movie.Domain.Category;
import dev.codex.cinestar.Movie.Domain.Movie;
import dev.codex.cinestar.Movie.Domain.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitle(String title);

    List<Movie> findByCategory(Category category);

    List<Movie> findByType(MovieType type);

//    List<Movie> findByAuthor(Author author);
}