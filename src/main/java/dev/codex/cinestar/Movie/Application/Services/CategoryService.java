package dev.codex.cinestar.Movie.Application.Services;

import dev.codex.cinestar.Movie.Application.Dtos.CategoryRequest;
import dev.codex.cinestar.Movie.Domain.Category;

import java.util.List;

public interface CategoryService extends CrudService<Category, Long, CategoryRequest>{
}
