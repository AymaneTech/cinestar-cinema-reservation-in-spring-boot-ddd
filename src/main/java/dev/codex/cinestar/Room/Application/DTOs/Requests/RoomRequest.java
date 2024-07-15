package dev.codex.cinestar.Room.Application.DTOs.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RoomRequest(
        @NotBlank
        String name,
        @NotNull
        Long capacity,
        @NotNull
        List<ZoneRequest> zones
) {
}
