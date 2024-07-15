package dev.codex.cinestar.Movie.Application.DTOs.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank
        String name,

        @NotBlank
        @Size(min = 30, max = 256)
        String description
) {
}
