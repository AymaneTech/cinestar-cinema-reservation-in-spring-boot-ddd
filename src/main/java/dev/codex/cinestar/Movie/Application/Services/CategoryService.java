package dev.codex.cinestar.Movie.Application.Services;

import dev.codex.cinestar.Movie.Application.Dtos.CategoryRequest;
import dev.codex.cinestar.Movie.Domain.Entities.Category;

public interface CategoryService extends CrudService<Category, Long, CategoryRequest>{
    Category findByName(String categoryName);
}
