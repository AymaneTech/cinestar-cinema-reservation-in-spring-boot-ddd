package dev.codex.cinestar.Movie.Application.Services;

import dev.codex.cinestar.Movie.Application.Dtos.MovieRequest;
import dev.codex.cinestar.Movie.Domain.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(Long id);
    Movie create(MovieRequest dto);
    Movie update(Long id, MovieRequest dto);
    void delete(Long id);
}
