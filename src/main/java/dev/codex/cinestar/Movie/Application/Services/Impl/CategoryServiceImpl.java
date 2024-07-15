package dev.codex.cinestar.Movie.Application.Services.Impl;

import dev.codex.cinestar.Movie.Application.Dtos.CategoryRequest;
import dev.codex.cinestar.Movie.Application.Services.CategoryService;
import dev.codex.cinestar.Movie.Domain.Category;
import dev.codex.cinestar.Movie.Infrastructure.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Category findByName(String categoryName) {
        return repository.findByName(categoryName)
                .orElseThrow(() -> new RuntimeException("category not found"));
    }

    @Override
    public Category create(CategoryRequest dto) {
        Category category = new Category(dto.name(), dto.description());
        return repository.save(category);
    }

    @Override
    public Category update(Long id, CategoryRequest dto) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(dto.name());
        category.setDescription(category.getDescription());
        return repository.save(category);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Category not found");

        repository.deleteById(id);
    }
}
