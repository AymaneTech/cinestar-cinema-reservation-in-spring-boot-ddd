package dev.codex.cinestar.Room.Application.DTOs.Requests;

import dev.codex.cinestar.Room.Domain.ValueObjects.ZonePosition;
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
        Long price,
        @NotNull
        ZonePosition position
) {
}
