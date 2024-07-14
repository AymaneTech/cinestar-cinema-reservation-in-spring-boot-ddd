package dev.codex.cinestar.Movie.Infrastructure;

import dev.codex.cinestar.Movie.Domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
}