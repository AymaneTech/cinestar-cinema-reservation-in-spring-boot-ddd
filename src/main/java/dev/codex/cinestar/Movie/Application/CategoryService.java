package dev.codex.cinestar.Movie.Application;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import dev.codex.cinestar.Movie.Domain.Category;
import dev.codex.cinestar.Movie.Infrastructure.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    private final CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category create(CategoryRequest dto) {
        Category category = mapper.map(dto, Category.class);
        assert category.getName().equals(dto.name());
        assert category.getDescription().equals(dto.description());
        return repository.save(category);
    }

    public Category update(Long id, CategoryRequest dto) {
        Category category = repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        mapper.map(dto, category);
        return repository.save(category);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
