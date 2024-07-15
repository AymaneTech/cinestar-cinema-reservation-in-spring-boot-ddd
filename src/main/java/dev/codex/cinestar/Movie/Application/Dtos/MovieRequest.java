package dev.codex.cinestar.Movie.Application.Dtos;

import dev.codex.cinestar.Movie.Domain.MovieType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public record MovieRequest(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        Long categoryId,

        @NotNull
        List<AuthorRequest> authors,

        @NotBlank
        String duration,

        @NotNull
        Date releaseDate,

        @NotBlank
        String director,

        @NotBlank
        String language,

        @NotNull
        MovieType type,

        @NotBlank
        String country
) {
}
