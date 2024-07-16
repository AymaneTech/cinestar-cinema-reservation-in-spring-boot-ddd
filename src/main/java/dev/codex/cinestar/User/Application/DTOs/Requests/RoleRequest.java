package dev.codex.cinestar.User.Application.DTOs.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link dev.codex.cinestar.User.Domain.Entities.Role}
 */
public record RoleRequest(
        @NotBlank
        String name,

        @NotNull
        List<Long> permissions
) implements Serializable {
}