package dev.codex.cinestar.Movie.Interfaces.Web;

import dev.codex.cinestar.Movie.Application.Dtos.MovieRequest;
import dev.codex.cinestar.Movie.Domain.Movie;
import dev.codex.cinestar.Movie.Application.Services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")

@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @GetMapping
    public List<Movie> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Movie create(@RequestBody @Validated MovieRequest dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody @Validated MovieRequest dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
