package dev.codex.cinestar.Movie.Application.DTOs.Requests;

import jakarta.validation.constraints.NotBlank;

public record AuthorRequest(@NotBlank String name) {}