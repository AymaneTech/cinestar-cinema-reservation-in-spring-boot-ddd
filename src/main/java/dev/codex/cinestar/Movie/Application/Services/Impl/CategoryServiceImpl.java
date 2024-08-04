package dev.codex.cinestar.Movie.Application.Services.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.codex.cinestar.Movie.Application.DTOs.Requests.CategoryRequest;
import dev.codex.cinestar.Movie.Application.Services.CategoryService;
import dev.codex.cinestar.Movie.Domain.Entities.Category;
import dev.codex.cinestar.Movie.Domain.Exceptions.CategoryNotFoundException;
import dev.codex.cinestar.Movie.Infrastructure.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    public Category findByName(String categoryName) {
        return repository.findByName(categoryName)
                .orElseThrow(() -> new CategoryNotFoundException(categoryName));
    }

    @Override
    @Transactional
    public Category create(CategoryRequest dto) {
        final Category category = modelMapper.map(dto, Category.class);
        System.out.println("here is the mapping result test again baqi mamtye9ch = " + category);
        return repository.save(category);
    }

    @Override
    @Transactional
    public Category update(Long id, CategoryRequest dto) {
        final Category category = repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
        category.setName(dto.name());
        category.setDescription(category.getDescription());
        return repository.save(category);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new CategoryNotFoundException(id);
        repository.deleteById(id);
    }
}
