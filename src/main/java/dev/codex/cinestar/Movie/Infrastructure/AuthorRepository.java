package dev.codex.cinestar.Movie.Infrastructure;

import dev.codex.cinestar.Movie.Domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}