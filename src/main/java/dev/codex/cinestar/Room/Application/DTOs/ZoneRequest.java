package dev.codex.cinestar.Room.Application.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ZoneRequest(

        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        Long capacity,
        @NotNull
        Long price
) {
}
