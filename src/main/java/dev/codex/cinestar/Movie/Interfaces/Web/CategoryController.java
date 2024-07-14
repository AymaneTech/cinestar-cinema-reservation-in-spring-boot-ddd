package dev.codex.cinestar.Movie.Interfaces.Web;

import dev.codex.cinestar.Movie.Application.Dtos.CategoryRequest;
import dev.codex.cinestar.Movie.Domain.Category;
import dev.codex.cinestar.Movie.Application.Services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")

@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public List<Category> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Category create(@RequestBody @Validated CategoryRequest dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody @Validated CategoryRequest dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
