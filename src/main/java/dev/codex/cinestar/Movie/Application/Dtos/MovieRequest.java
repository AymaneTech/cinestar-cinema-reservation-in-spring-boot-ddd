package dev.codex.cinestar.Movie.Application.Dtos;

import dev.codex.cinestar.Movie.Domain.MovieType;

import java.util.Date;
import java.util.List;

public record MovieRequest(
        String title,
        String description,
        Long categoryId,
        List<AuthorRequest> authors,
        String duration,
        Date releaseDate,
        String director,
        String language,
        MovieType type,
        String country
) {
}
