package dev.codex.cinestar.Movie.Interfaces.Web;

import dev.codex.cinestar.Movie.Application.DTOs.Requests.MovieRequest;
import dev.codex.cinestar.Movie.Application.Services.MovieService;
import dev.codex.cinestar.Movie.Domain.Entities.Movie;
import dev.codex.cinestar.Movie.Domain.ValueObjects.MovieType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        List<Movie> movies = service.findAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        Movie movie = service.findById(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/filter/title")
    public ResponseEntity<List<Movie>> filterByTitle(@RequestParam String title) {
        List<Movie> movies = service.filterByTitle(title);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/filter/category")
    public ResponseEntity<List<Movie>> filterByCategory(@RequestParam String category) {
        List<Movie> movies = service.filterByCategory(category);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/filter/type")
    public ResponseEntity<List<Movie>> filterByMovieType(@RequestParam MovieType type) {
        List<Movie> movies = service.filterByMovieType(type);
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody @Valid MovieRequest dto) {
        Movie createdMovie = service.create(dto);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody @Valid MovieRequest dto) {
        Movie movie = service.update(id, dto);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
