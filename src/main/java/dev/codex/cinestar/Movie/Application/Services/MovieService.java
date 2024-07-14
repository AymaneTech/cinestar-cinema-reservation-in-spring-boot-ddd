package dev.codex.cinestar.Movie.Application.Services;

import dev.codex.cinestar.Movie.Application.Dtos.MovieRequest;
import dev.codex.cinestar.Movie.Domain.Movie;

import java.util.List;

public interface MovieService extends CrudService<Movie, Long, MovieRequest> {
    List<Movie> filterByName(String name);

    List<Movie> filterByCategory(String categoryName);

    List<Movie> filterByMovieType(String type);

    List<Movie> filterByAuthor(String type);
}
