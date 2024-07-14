package dev.codex.cinestar.Movie.Infrastructure;

import dev.codex.cinestar.Movie.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}