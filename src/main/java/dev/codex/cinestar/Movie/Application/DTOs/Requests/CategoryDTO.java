package dev.codex.cinestar.Movie.Application.DTOs.Requests;

import jakarta.validation.constraints.NotBlank;

/**
 * CategoryDTO
 */
public class CategoryDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String descritpion;

    public CategoryDTO(String name, String description) {
        this.name = name;
        this.descritpion = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return descritpion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }     
}
